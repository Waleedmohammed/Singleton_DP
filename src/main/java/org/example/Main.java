package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Browser instance1 = Browser.getBrowser();

        // Serialization the Browser instance
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("browser.json"));
        out.writeObject(instance1);
        out.close();

        // De-Serialization the Browser instance
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("browser.json"));
        Browser instance2 = (Browser) in.readObject();
        in.close();

        System.out.println("Instance 1 hash code "+ instance1.hashCode());
        System.out.println("Instance 2 hash code "+ instance2.hashCode());

    }
}