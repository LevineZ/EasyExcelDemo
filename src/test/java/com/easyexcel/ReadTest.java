package com.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.easyexcel.read.DemoData;
import com.easyexcel.read.DemoDataListener;
import com.easyexcel.util.TestFileUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ReadTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(ReadTest.class);

    @Test
    public void simpleRead() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        EasyExcel.read(fileName, DemoData.class, (ReadListener) new DemoDataListener()).sheet().doRead();
        /**
         * 写法2
         */
//        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        ExcelReader excelReader = EasyExcel.read(fileName, DemoData.class, (ReadListener) new DemoDataListener()).build();
//        ReadSheet readSheet = EasyExcel.readSheet(0).build();
//        excelReader.read(readSheet);
//        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//        excelReader.finish();
    }
}