package org.example;

public class Browser {

    // 1. Private static instance of the class
    private   static Browser browser;

    // 2. private constructor of the class
    private Browser() {

        // here we are securing Singleton pattern from Reflection hacking
        if (browser !=null){
            throw  new IllegalArgumentException("Object already Exist");
        }
    }

    // 3. public static getInstance method
    public static Browser getBrowser() {
        if (browser == null) {
            synchronized (Browser.class){
                if (browser == null) {
                    browser = new Browser();
                }
            }
        }
        return browser;
    }

    // 4. Individual public method
    public void displayMessage(){
        System.out.println("Hi Singleton");
    }


}
