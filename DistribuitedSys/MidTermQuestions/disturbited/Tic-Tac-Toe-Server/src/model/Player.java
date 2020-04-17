package model;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public abstract class Player implements Runnable {
    protected int player;
    protected Socket socket;
    protected Player opponent;
    public Scanner input;
    protected Player currentPlayer;
    protected Game game;
    public PrintWriter output;

    public Player(Socket socket, int player, Game game){
        this.player = player;
        this.socket = socket;
        this.game = game;
    }

    public abstract void setup() throws Exception;
    public abstract void process();
    public abstract void processMove(int location);

}