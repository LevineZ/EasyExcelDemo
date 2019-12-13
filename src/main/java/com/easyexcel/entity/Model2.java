package com.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Model2 extends BaseRowModel {
    @ExcelProperty(value = "订单号", index = 0)
    private String orderNo;

    @ExcelProperty(value = "创建人", index = 1)
    private String name;

    @ExcelProperty(value = "创建时间", index = 2)
    private LocalDateTime createTime;


}