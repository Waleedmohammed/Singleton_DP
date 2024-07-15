package org.example;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Browser instance1 = Browser.getBrowser();
        instance1.clone();

        Browser instance2 = (Browser) instance1.clone();

    }
}