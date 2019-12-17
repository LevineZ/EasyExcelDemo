package com.easyexcel.data.read;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class IndexOrNameData  {
    @ExcelProperty(index = 1)      //强制读取第二个，easyexcel文档中不建议index和name同时使用
    private Double doubledate;
    /**
     * 用名字匹配，但是若名字匹配会导致只有一个字段读取到数据
     */
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;

}