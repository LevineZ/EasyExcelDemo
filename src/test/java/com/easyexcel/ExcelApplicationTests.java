package com.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.easyexcel.entity.Model1;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@SpringBootTest
class ExcelApplicationTests {

	//simple
	private List<Model1> createModelList() {
		List<Model1> Model1s = Lists.newArrayList();
		for (int i = 0; i < 100; i++) {
			Model1 model1 = com.easyexcel.entity.Model1.builder().age(20 + i).name("Levine").password("12345").build();
			Model1s.add(model1);
		}
		return Model1s;
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


}
