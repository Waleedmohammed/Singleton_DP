package org.example;

public class Browser implements Cloneable {

    // 1. Private static instance of the class
    private static Browser browser;

    // 2. private constructor of the class
    private Browser() {

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("singleton instance can not be cloned");

    }

}
