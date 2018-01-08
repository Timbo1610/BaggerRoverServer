package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;

public class Main {

    public static void main(String[] args) {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket;
        boolean running = false;
        try {
            welcomeSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            running = true;
            BufferedReader inFromClient =
                    null;
            try {
                inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            while(running)
            {
                clientSentence = inFromClient.readLine();
                if(clientSentence != null)
                    System.out.println(System.currentTimeMillis()  + ": " + clientSentence);
                else {
                    System.out.println(System.currentTimeMillis() + ": Client exited");
                    running = false;
                }
            }

        }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
