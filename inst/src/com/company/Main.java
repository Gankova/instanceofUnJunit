package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        JSNumber<String> number = new JSNumber<String>("12");
        System.out.println(number.equals(12));
        System.out.println(number.equals("12"));
        System.out.println(number.equals("12.0000"));
        System.out.println(number.equals(12.));
        System.out.println(number.equals(12.8f));

        try {
            JSNumber<Object> number1 = new JSNumber<>(new Object());
            System.out.println(number.equals("15"));
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


    }
}
