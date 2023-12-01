package org.example;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Main {
    private static Socket socket1;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;

    public static void main(String[] args) {
        try {
            try {
                System.out.println("старт клиента...");
                socket1 = new Socket("localhost", 4004);
                while (true) {
                    in = new ObjectInputStream(socket1.getInputStream());
                    out = new ObjectOutputStream(socket1.getOutputStream());
                    sleep(5000);
                    out.writeObject("Hello");
                    out.flush();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Клиент был закрыт...");
                socket1.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}