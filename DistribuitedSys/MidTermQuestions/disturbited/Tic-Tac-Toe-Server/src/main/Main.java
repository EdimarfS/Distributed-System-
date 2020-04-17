package main;


import model.Game;
import model.Human;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    private static final int SERVER_PORT = 5601;



    public static void main(String [] args) {

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is running ...");

            ExecutorService executorService = Executors.newFixedThreadPool(200);

            while(true) {
                Game game = new Game();

                executorService.execute(game.new Human(serverSocket.accept(), 1, game));
                executorService.execute(game.new Human(serverSocket.accept(), 2, game));
            }

        } catch (Exception ex) {
            System.out.println(ex);
            System.exit(1);
        }
    }
}
