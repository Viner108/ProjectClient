package org.example;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Main {
    private static String HOST = "localhost";
    private static int PORT = 8081;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(HOST, PORT);

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("Hello");
        out.println("World");
        out.println("How are you?");


        out.close();
        socket.close();
    }
}