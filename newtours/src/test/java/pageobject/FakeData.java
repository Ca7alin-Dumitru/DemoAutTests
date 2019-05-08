package pageobject;

import com.github.javafaker.Faker;

public class FakeData {
    private static Faker ourInstance = null;

    private FakeData() {
    }

    public static Faker getInstance()
    {
        if (ourInstance == null) {
            ourInstance = new Faker();
        }

        return ourInstance;
    }
}
