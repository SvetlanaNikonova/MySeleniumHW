package test.first.pom.utils;

import java.util.Random;

public class TestUtils {

    public static int getRandomNumber(int upperValue) {
        Random r = new Random();
        return r.nextInt(upperValue);
    }
}