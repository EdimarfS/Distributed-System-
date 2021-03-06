package model;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;

public class Game {

    private Player[] board = new Player[9];

    Player currentPlayer;

    public boolean hasWinner() {
        return (board[0] != null && board[0] == board[1] && board[0] == board[2])
                || (board[3] != null && board[3] == board[4] && board[3] == board[5])
                || (board[6] != null && board[6] == board[7] && board[6] == board[8])
                || (board[0] != null && board[0] == board[3] && board[0] == board[6])
                || (board[1] != null && board[1] == board[4] && board[1] == board[7])
                || (board[2] != null && board[2] == board[5] && board[2] == board[8])
                || (board[0] != null && board[0] == board[4] && board[0] == board[8])
                || (board[2] != null && board[2] == board[4] && board[2] == board[6]
        );
    }

    public boolean isBoardFilledUp() {
        return Arrays.stream(board).allMatch(Objects::nonNull);
    }

    public synchronized void move(int location, Player player) {
        if (player != currentPlayer) {
            throw new IllegalStateException("Wait for your turn");
        } else if (player.opponent == null) {
            throw new IllegalStateException("No Opponent yet");
        } else if (board[location] != null) {
            throw new IllegalStateException("Cell is not empty");
        }

        board[location] = currentPlayer;
        currentPlayer = currentPlayer.opponent;
    }
}