package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
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
        return name.replaceAll("-", "").substring(5);
    }

    public static String randomDateBefore() throws ParseException {
        String randomDate = String.valueOf(Instant.now().minus(Duration.ofDays(random.nextInt(365) + 1)));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(randomDate);
        return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }
}