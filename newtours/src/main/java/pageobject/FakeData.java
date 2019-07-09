package pageobject;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public enum FakeData {
    INSTANCE;

    private static Faker connection = null;

    @Step
    public static Faker getFake() {
        if (connection == null) {
            connection = new Faker();
        }

        return connection;
    }
}
