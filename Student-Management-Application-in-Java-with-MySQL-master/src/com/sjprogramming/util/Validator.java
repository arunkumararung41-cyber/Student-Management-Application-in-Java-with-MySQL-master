package com.sjprogramming.util;

public class Validator {

    public static boolean isValidName(String name){
        return name != null && name.trim().length() >= 3;
    }

    public static boolean isValidPercentage(double p){
        return p >= 0 && p <= 100;
    }

    public static boolean isValidId(int id){
        return id > 0;
    }
}