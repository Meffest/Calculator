package ru.andzhey.clinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Анджей on 13.05.2016.
 */
public class ConsoleHelper {
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return reader.readLine();
    }

    /**
     * Created by Анджей on 13.05.2016.
     */
    public static class Dog implements Pet {
        private String name;

        public Dog(final String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String getPetType() {
            return "ru.andzhey.clinic.ConsoleHelper.Dog";
        }
    }
}
