package com.sda.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandlerTask implements Runnable {

    private Socket clientSocket;

    public ClientHandlerTask(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.printf("Thread: %s handles client request\n", Thread.currentThread()
                .getName());

        try {
            System.out.println("Client IP:"
                    + "" + clientSocket.getInetAddress()
                    .getHostAddress());
            // BufferedReader odczytuje to co wyslal klient
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // PrintWriter sluzy do wysylania wiadomosci do klienta
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());

            // Odczytaj linijke od klienta
            String line = reader.readLine();
            System.out.println("Received: " + line);
            // Odpowiedz do klienta
            printWriter.println("Response from server: " + line);
            // flush - wypchnij z bufora
            printWriter.flush();
            // Zamknij strumienie
            printWriter.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("Handling client request finished");

    }
}