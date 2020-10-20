package com.unis.common_module.config;

public class MoxinConfig {

    public static final int TX = 1;
    public static final int HX = 2;
    public static String SERVICE_PHONE = "123456";
    public static String TOKEN = "";
    public static final boolean DEBUG = Boolean.parseBoolean("true");
    public static final boolean LOG_DEBUG = true;
    private static int IM_CHANNELS = TX;

    public static String DB_NAME = "school-db";

    public static int getImChannels() {
        return IM_CHANNELS;
    }

}
