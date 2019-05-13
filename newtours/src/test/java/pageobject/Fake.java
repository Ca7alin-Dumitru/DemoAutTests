package pageobject;

import com.github.javafaker.Faker;

public enum Fake {
    INSTANCE;

    private static Faker connection = null;

    public static Faker getFake() {
        if (connection == null) {
            connection = new Faker();
        }

        return connection;
    }
}
