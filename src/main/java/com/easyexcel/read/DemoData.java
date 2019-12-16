package com.easyexcel.read;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DemoData {
    private String string;
    private Date date;
    private Double doubleData;
}