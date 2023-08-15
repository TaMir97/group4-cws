package org.example.ui;

import java.lang.reflect.Method;

public class Logic {
    public static <T> void invokeMethod(String methodName, Class <T> userClass) {
        try {
            Method method = userClass.getDeclaredMethod(methodName);
            method.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
