package data.generator;

import faker.*;

public class Name {

    public static String firstName(){
        return FakeData.INSTANCE.getFake().name().firstName();
    }

    public static String lastName(){
        return FakeData.INSTANCE.getFake().name().lastName();
    }

    public static String fullName(){
        return FakeData.INSTANCE.getFake().name().firstName() + " " +  FakeData.INSTANCE.getFake().name().lastName();
    }

}
