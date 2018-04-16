package com.sda.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {


    public static void main(String[] args) throws IOException {

        //host serwera
        String host = "localhost";
        //port serwera
        int port = 4444;

        //Tworzymy gniazdo do polaczenia z serwerem
        Socket socket = new Socket(host,port);
        //BufferedReader odczyt z serwera
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //PrintWriter - wysylanie do serwera
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        //Wyslij do serwera
        printWriter.println("Hello from client!");
        //Wypchnij z bufora
        printWriter.flush();

        //Odczytaj od serwera
        String response = reader.readLine();
        System.out.println("Response: "+response);
        //Zamknij strumienie
        printWriter.close();
        reader.close();


    }
}
