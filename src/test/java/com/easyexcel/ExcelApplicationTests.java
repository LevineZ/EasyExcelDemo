package com.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.easyexcel.entity.Model1;
import com.easyexcel.entity.Model2;
import com.easyexcel.util.DataUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ExcelApplicationTests {

	//simple excel建立，插入100行数据
	private List<Model1> createModelList() {
		List<Model1> Model1s = Lists.newArrayList();
		for (int i = 0; i < 100; i++) {
			Model1 model1 = com.easyexcel.entity.Model1.builder().age(20 + i).name("Levine").password("12345").build();
			Model1s.add(model1);
		}
		return Model1s;
	}
	//Model2实例，特殊场景
    private List<Model2> createModel1List() {
        List<Model2> Model2s = Lists.newArrayList();
        for (int i = 100; i < 100; i++) {
            Model2 writeModel = Model2.builder().orderNo(String.valueOf(i)).name("Levine").createTime(LocalDateTime.now()).build();
            Model2s.add(writeModel);
        }
        return Model2s;
    }

    /**
     * 无注解的实体类
     * @return
     */
    private List<List<Object>> createDynamicModelList() {
        // 所有行数据
        List<List<Object>> rows = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            // 一行数据
            List<Object> row = new ArrayList<>();
            row.add("字符串" + i);
            row.add(Long.valueOf(187837834l + i));
            row.add(Integer.valueOf(2233 + i));
            row.add("Levine");
            row.add("2333333333");
            rows.add(row);
        }
        return rows;
    }


	@Test
	public void writeExcelSimple() throws IOException {
		OutputStream out = new FileOutputStream("自定义的本地路径");
		ExcelWriter writer = EasyExcelFactory.getWriter(out);
		Sheet sheet1 = new Sheet(1, 0, Model1.class);
		sheet1.setSheetName("第一个sheet");
		writer.write(createModelList(), sheet1);
		writer.finish();
		out.close();
	}

    /**
     * 动态生成Ｅｘｃｅｌ内容
     * @throws IOException
     */
    @Test
    public void writeExcel1() throws IOException {
        OutputStream outputStream = new FileOutputStream("自定义的本地路径");
        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("NO.1");
        Table table = new Table(1);
        table.setHead(DataUtil.createTestListStringHead());//无注解模式，动态添加表头
        writer.write1(createDynamicModelList(), sheet, table);
        // 合并单元格
        writer.merge(5, 6, 0, 4);
        writer.finish();
        outputStream.close();
    }

    //合并多个sheet
    @Test
    public void writeExcel() throws IOException {
        OutputStream out = new FileOutputStream("G:/excel/EasyExcel/test4.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);
        // ==================================== Start ====================================
        // 写仅有一个 Sheet 的 Excel, 此场景较为通用
        Sheet sheet1 = new Sheet(1, 0, Model1.class);
        sheet1.setSheetName("第一个sheet");
        writer.write(createModel1List(), sheet1);
        // ===================================== End =====================================
        Sheet sheet2 = new Sheet(2, 0, Model1.class, "NO,2", null);
        writer.write(createModelList(), sheet2);
        // ==================================== Start ====================================
        // 合并单元格
        Sheet sheet3 = new Sheet(3, 0, Model1.class, "第三个sheet", null);
        //writer.write1(null, sheet2);
        writer.write(createModelList(), sheet3);
        // 需要合并单元格
        writer.merge(5, 6, 1, 5);
        // ===================================== End =====================================
        // ==================================== Start ====================================
        // 单个 Sheet 中包含多个 Table
        Sheet sheet4 = new Sheet(4, 0);
        sheet4.setSheetName("第四个sheet");
        Table sheet4table1 = new Table(1);
        sheet4table1.setClazz(Model1.class);
        writer.write(createModelList(), sheet4, sheet4table1);
        Table sheet4table2 = new Table(2);
        sheet4table2.setClazz(Model1.class);
        writer.write(createModel1List(), sheet4, sheet4table2);
        // ===================================== End =====================================
        writer.finish();
        out.close();
    }

}
