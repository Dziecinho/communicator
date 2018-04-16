package com.sda.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        //host serwera
        String host = "localhost";
        //port serwera
        int port = 4444;

        System.out.println("KAMIL");

        while (true) {
            //Tworzymy gniazdo do polaczenia z serwerem
            Socket socket = new Socket(host, port);
            //BufferedReader odczyt z serwera
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //PrintWriter - wysylanie do serwera
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            String message = scanner.nextLine();

            //Wyslij do serwera
            printWriter.println(message);
            //Wypchnij z bufora
            printWriter.flush();

            //Odczytaj od serwera
            String response = reader.readLine();
            System.out.println(response);
            //Zamknij strumienie
            printWriter.close();
            reader.close();
        }


    }
}
