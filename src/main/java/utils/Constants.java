package utils;

import java.util.Random;

public class Constants {

    private static Random random = new Random();
    public static final String LOGIN_PAGE_URL = "https://zenistock.zenitech.local/login";
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "qazqwer1@d.";
    public static final String DEVICE_NAME = "Laptop DELL";
    public static final String DEVICE_SERIAL_NO = random.nextInt(100000) + "";
    public static final String DEVICE_INVENTORY_NO = random.nextInt(100000) + "";
    public static final String DEVICE_INVOICE_NO = random.nextInt(1000000) + "";
    public static final String DEVICE_DESCRIPTION = "Touchpad defect";
    public static final String DEVICE_NAME_WS = "Laptop DELL ";
    public static final String DEVICE_SERIAL_NO_WS = "A23456 ";
    public static final String DEVICE_INVENTORY_NO_WS = "25 ";
    public static final String DEVICE_INVOICE_NO_WS = "LD56 ";
    public static final String DEVICE_DESCRIPTION_WS = "  ";
    public static final String DEVICE_NAME_TOO_LONG = "This is a test name that has over one hundred characters and it will be invalidated by the application";
    public static final String DEVICE_NUMBER_OVER_30_CHAR = "1234567899876543211234567789901";

}
