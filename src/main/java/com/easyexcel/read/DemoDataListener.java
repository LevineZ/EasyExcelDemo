package com.easyexcel.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * //由于默认异步读取excel，所以需要创建excel一行一行的回调监听器DemoDataListener 不能被spring管理，
 * 要每次读取excel都要new,然后里面用到spring可以构造方法传进去
 */
public class DemoDataListener extends AnalysisEventListener<DemoData> {
    public static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);

    /**
     * 将读取的数据每隔五条存入数据库
     */
    public static final int BATCH_COUNT = 5;
    List<DemoData> list = new ArrayList<>();


    /**
     * 存储对象
     */
    private DemoDAO demoDAO;
    public DemoDataListener() {
        demoDAO = new DemoDAO();
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        demoDAO.save(list);
        LOGGER.info("存储数据库成功！");
    }

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        LOGGER.info("解析到数据：{}", com.alibaba.fastjson.JSON.toJSONString(demoData));
        list.add(demoData);
        //达到5条数据，需要存贮数据库，防止out of memory
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();//存储完成清理list
        }
    }

    /**
     *所有数据解析为完成，来调用此方法
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //确保最后的数据存入数据库
        saveData();
        LOGGER.info("所有数据解析完成");
    }


}