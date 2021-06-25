package com.company;

public class Main2 {
    public static void main(String[] args) {
        int sum  = 0;
        for (String number: args) {
            int n = Integer.parseInt(number);
            sum +=n;
        }
        System.out.println(sum);

    }
}
