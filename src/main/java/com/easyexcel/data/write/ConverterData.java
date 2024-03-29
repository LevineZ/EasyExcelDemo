package com.easyexcel.data.write;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ConverterData {

	/**
	 * 我想所有的 字符串起前面加上"自定义："三个字
	 */
	@ExcelProperty(value = "字符串标题", converter = CustomStringStringConverter.class)
	private String string;
	/**
	 * 我想写到excel 用年月日的格式
	 */
	@DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
	@ExcelProperty("日期标题")
	private Date date;
	/**
	 * 我想写到excel 用百分比表示
	 */
	@NumberFormat("#.##%")
	@ExcelProperty(value = "数字标题")
	private Double doubleData;
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getDoubleData() {
		return doubleData;
	}
	public void setDoubleData(Double doubleData) {
		this.doubleData = doubleData;
	}
	
}
