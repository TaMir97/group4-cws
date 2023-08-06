package org.example;

import java.util.regex.Pattern;

public class Convert {
    public static int stringToInt(String str) {
        String regex = "^[0-9\\s-]+$";
       if (!Pattern.matches(regex,str) || (Integer.parseInt(str)>32767 || Integer.parseInt(str)< -32768)){
           throw new RuntimeException();
       }
       return Integer.parseInt(str);
    }


}
