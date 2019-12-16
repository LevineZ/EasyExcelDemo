package com.easyexcel.util;

import java.io.File;
import java.io.InputStream;

public class TestFileUtil {
    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

    public static String getPath() {
        return TestFileUtil.class.getResource("/").getPath();
    }
}