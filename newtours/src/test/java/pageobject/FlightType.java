package pageobject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum FlightType {
    ROUNDTRIP,
    ONEWAY,
    ECONOMY,
    BUSINESS,
    FIRST;

    private static final List<FlightType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    //todo colectii, list, -arraylist, map, -hashmap, -concurentmap
    public static FlightType randomFlight()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    //todo https://docs.oracle.com/javase/8/docs/api/
}
