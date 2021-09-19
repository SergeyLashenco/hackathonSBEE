package com.example.hackathonsbee.untils;

import java.util.stream.Collectors;

public class RandomGenerateEmailAddress {

    public static String randomStringEmail(int i) {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        String random = new java.util.Random().ints(i, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        StringBuilder st = new StringBuilder();
        st.append(random).append("@mail.com");
        return st.toString();
    }
}
