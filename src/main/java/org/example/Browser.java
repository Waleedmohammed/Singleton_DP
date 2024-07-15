package org.example;

import java.io.Serializable;

public class Browser implements Serializable {

    // 1. Private static instance of the class
    private static Browser browser;

    // 2. private constructor of the class
    private Browser() {

        if (browser != null) {
            throw new IllegalArgumentException("Object already exist");
        }

    }

    // 3. public static getInstance method
    public static Browser getBrowser() {
        if (browser == null) {
            synchronized (Browser.class) {
                if (browser == null) {
                    browser = new Browser();
                }
            }
        }
        return browser;
    }

    // 4. Individual public method
    public void displayMessage() {
        System.out.println("Hi Singleton");
    }

    // To Prevent serialization hacking for Singleton pattern
    // Add readResolve() -- Which will be called during De-Serialization process -- this will return class instance
    protected Object readResolve() {
        return getBrowser();
    }


}
