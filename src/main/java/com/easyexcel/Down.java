package com.easyexcel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Down {
    @GetMapping("/a.htm")
    public void cooperation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .getBytes(), "UTF-8");
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("第一个sheet");
        //writer.write0(getListString(), sheet1);
        writer.finish();
        out.flush();
    }
}
