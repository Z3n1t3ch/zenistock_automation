package utils;


import static utils.RandomGenerator.randomName;
import static utils.RandomGenerator.randomNumber;

public class Constants {
    public static final String BASE_URL = "https://zenistock.zenitech.local/";
    public static final String login = "https://zenistock.zenitech.local/login";
    public static final String dashboard = "https://zenistock.zenitech.local/dashboard";
    public static final String device_details = "https://zenistock.zenitech.local/device-details";
    public static final String DEVICES_URL = BASE_URL + "devices";
    public static final String TAGS_URL = BASE_URL + "tags";
    public static final String ASSETS_URL = BASE_URL + "assets";
    public static final String EMPLOYEES_URL = BASE_URL + "users";
    public static final String LICENSES_URL = BASE_URL + "licenses";
    public static final String LICENSE_DETAILS_URL = BASE_URL + "license-details";
    public static final String DEVICE_DESCRIPTION = "Touchpad defect";
    public static final String DEVICE_NAME_WS = "Laptop Lenovo ";
    public static final String DEVICE_SERIAL_NO_WS = "A23456 ";
    public static final String DEVICE_INVENTORY_NO_WS = "25 ";
    public static final String DEVICE_INVOICE_NO_WS = "LD56 ";
    public static final String DEVICE_DESCRIPTION_WS = "  ";
    public static final String DEVICE_NAME_TOO_LONG = "This is a test name that has over one hundred characters and it will be invalidated by the application";
    public static final String DEVICE_NUMBER_OVER_30_CHAR = "1234567899876543211234567789901";
    public static final String LICENSE_NAME_WS = "135";
    public static final String LICENSE_NAME_edit = "1356";
    public static final String WHITE_SPACE_NAME_WS = "     ";
    public static final String PURCHASE_DATE_WS = "01/04/2022";
    public static final String EXPIRATION_DATE_WS = "01/08/2022";
    public static final String LICENSE_NAME_IS_TOO_LONG = "This is a test name that has over one hundred characters and it will be invalidated by the application";
    public static String NAME = "0";
    public static final String WARRANTY_START_DATE = "22/06/2022";
    public static final String WARRANTY_END_DATE = "23/07/2022";
    public static final String WARRANTY_END_DATE_ERROR = "01/06/2022";
    public static final String INVOICE_DATE = "07/07/2022";
    public static final String name = randomName() + "";
    public static final String number = "0000" + randomNumber() + "";
}

