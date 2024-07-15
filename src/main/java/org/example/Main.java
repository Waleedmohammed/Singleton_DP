package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // Reflection can hack Singleton pattern (Reflection Attack)

        Browser instance1 = Browser.getBrowser();
        Browser instance2 ;

        Constructor<Browser> constructor = Browser.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        instance2= constructor.newInstance();
        System.out.println("hashcode of instance 1"+ instance1.hashCode());
        System.out.println("hashcode of instance 2"+ instance2.hashCode());

    }
}