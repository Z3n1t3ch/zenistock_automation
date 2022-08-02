package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomGenerator {
    private static Random random = new Random();

    public static int randomNumber() {
        return random.nextInt(10000);
    }

    public static String randomName() {
        String name = UUID.randomUUID().toString();
        return name.replaceAll("-", "");
    }

}
