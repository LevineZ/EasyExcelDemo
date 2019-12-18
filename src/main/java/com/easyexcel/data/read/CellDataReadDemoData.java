package com.easyexcel.data.read;

import com.alibaba.excel.metadata.CellData;
import lombok.Data;

import java.util.Date;

@Data
public class CellDataReadDemoData {
	private CellData<String> string;
    // 这里注意 虽然是日期 但是 类型 存储的是number 因为excel 存储的就是number
    private CellData<Date> date;
    private CellData<Double> doubleData;
    // 这里并不一定能完美的获取 有些公式是依赖性的 可能会读不到 这个问题后续会修复
    private CellData<String> formulaValue;
	public CellData<String> getString() {
		return string;
	}
	public void setString(CellData<String> string) {
		this.string = string;
	}
	public CellData<Date> getDate() {
		return date;
	}
	public void setDate(CellData<Date> date) {
		this.date = date;
	}
	public CellData<Double> getDoubleData() {
		return doubleData;
	}
	public void setDoubleData(CellData<Double> doubleData) {
		this.doubleData = doubleData;
	}
	public CellData<String> getFormulaValue() {
		return formulaValue;
	}
	public void setFormulaValue(CellData<String> formulaValue) {
		this.formulaValue = formulaValue;
	}
    
    
}
