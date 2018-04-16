package com.sda.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        //Port na ktorym startuje serwer
        int port = 4444;
        // Czas uspienia - 5 sek
        long SLEEP_TIME = 5_000L;
        //ServerSocker - gniazdo serwera. Sluzy do przyjmowania klientow TCP
        ServerSocket serverSocket = new ServerSocket(port);
        //      System.out.println("Started server on port " + port);
        System.out.println("JANUSZ");

        while (true) {
            //      System.out.println("Waiting for client...");
            //Czekaj na klienta
            Socket clientSocket = serverSocket.accept();
            //BufferedReader odczytuje to co wyslal klient
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //PrintWriter sluzy do wysylania wiadomosci do klienta
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());

            //Odczytaj linijke od klienta
            String line = reader.readLine();
            System.out.println(line);
            //Uspij na 5 sek. Symulacja obliczen
            //      Thread.sleep(SLEEP_TIME);
            //Odpowiedz do klienta
            //      printWriter.println("Response from server: " + line);

            String message = scanner.nextLine();
            printWriter.println(message);
            //flush - wypchnij z bufora
            printWriter.flush();
            //Zamknij strumienie
            printWriter.close();
            reader.close();
        }
    }
}
