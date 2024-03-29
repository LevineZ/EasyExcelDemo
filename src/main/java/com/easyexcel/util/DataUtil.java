package com.easyexcel.util;

import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.TableStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static List<List<Object>> createTestListObject() {
        List<List<Object>> rows = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            // 一行数据
            List<Object> row = new ArrayList<Object>();
            row.add("字符串"+i);
            row.add(Long.valueOf(187837834l+i));
            row.add(Integer.valueOf(2233+i));
            row.add(Double.valueOf(2233.00+i));
            row.add(Float.valueOf(2233.0f+i));
            row.add(new BigDecimal("3434343433554545"+i));
            row.add(Short.valueOf((short)i));
            rows.add(row);
        }
        return rows;
    }

    public static List<List<String>> createTestListStringHead(){
        // 模型上没有注解，表头数据动态传入
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        List<String> headCoulumn4 = new ArrayList<String>();
        List<String> headCoulumn5 = new ArrayList<String>();

        headCoulumn1.add("第一列");headCoulumn1.add("第一列");headCoulumn1.add("第一列");
        headCoulumn2.add("第一列");headCoulumn2.add("第一列");headCoulumn2.add("第一列");
        headCoulumn3.add("第二列");headCoulumn3.add("第二列");headCoulumn3.add("第二列");
        headCoulumn4.add("第三列");headCoulumn4.add("第三列2");headCoulumn4.add("第三列2");
        headCoulumn5.add("第一列");headCoulumn5.add("第3列");headCoulumn5.add("第4列");

        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        head.add(headCoulumn4);
        head.add(headCoulumn5);
        return head;
    }

    public static TableStyle createTableStyle() {
        TableStyle tableStyle = new TableStyle();
        // 设置表头样式
        Font headFont = new Font();
        // 字体是否加粗
        headFont.setBold(true);
        // 字体大小
        headFont.setFontHeightInPoints((short)12);
        // 字体
        headFont.setFontName("楷体");
        tableStyle.setTableHeadFont(headFont);
        // 背景色
        tableStyle.setTableHeadBackGroundColor(IndexedColors.BLUE);


        // 设置表格主体样式
        Font contentFont = new Font();
        contentFont.setBold(true);
        contentFont.setFontHeightInPoints((short)12);
        contentFont.setFontName("黑体");
        tableStyle.setTableContentFont(contentFont);
        tableStyle.setTableContentBackGroundColor(IndexedColors.GREEN);
        return tableStyle;
    }

    public static TableStyle createChongqingTableStyle() {
        // 表头样式
        TableStyle tableStyle = new TableStyle();
        Font headFont = new Font();
        headFont.setBold(true);
        headFont.setFontHeightInPoints((short)12);
        headFont.setFontName("微软雅黑");
        tableStyle.setTableHeadFont(headFont);
        // 内容背景色
        tableStyle.setTableHeadBackGroundColor(IndexedColors.BLUE1);

        // 内容样式
        Font contentFont = new Font();
        contentFont.setFontHeightInPoints((short)12);
        contentFont.setFontName("微软雅黑");
        tableStyle.setTableContentFont(contentFont);
        // 内容背景色
        tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE);
        return tableStyle;
    }
}