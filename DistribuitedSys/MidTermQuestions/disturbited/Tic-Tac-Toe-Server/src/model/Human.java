package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Human extends Player {

    public Human(Socket socket, int player, Game game){
        super(socket, player, game);
        this.player = player;
        System.out.println("Player 'Human' created!");
    }

    @Override
    public void run() {
        try {
            setup();
            process();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (opponent != null && opponent.output != null) {
                opponent.output.println("player left");
            }
            try {
                System.out.println("Closing Socket");
                socket.close();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void setup() throws Exception {
        input = new Scanner(socket.getInputStream());
        output = new PrintWriter(socket.getOutputStream(), true);
        output.println("Welcome Player " + player);
        if (player == 1) {
            currentPlayer = this;
            output.println("Waiting for opponent");
        } else {
            opponent = currentPlayer;
            opponent.opponent = this;
            opponent.output.println("Make your move");
        }
    }

    @Override
    public void process() {
        while (input.hasNextLine()) {
            String command = input.nextLine();
            if (command.startsWith("quit")) {
                return;
            } else if (command.startsWith("move")) {
                processMove(Integer.parseInt(command.substring(5)));
            }
        }
    }

    @Override
    public void processMove(int location) {
        try {
            game.move(location, this);
            output.println("valid move");
            opponent.output.println("opponent has moved: " + location + " your turn");
            if (game.hasWinner()) {
                output.println("won");
                opponent.output.println("lost");
            } else if (game.isBoardFilledUp()) {
                output.println("draw");
                opponent.output.println("draw");
            }
        } catch (IllegalStateException e) {
            output.println("Wrong Move: " + e.getMessage());
        }
    }
}