package conway;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {
    private GameOfLife game;

    public Main(GameOfLife game) {
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[][] grid = game.getGrid();
        int cellSize = 20; // Dimensione di ogni cella

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY);
                g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GameOfLife game = new GameOfLife(25, 25);
        // Configurazione di un oscillatore (Blinker)
        game.setCell(11, 12, 1);
        game.setCell(12, 12, 1);
        game.setCell(13, 12, 1);

        // Configurazione di un'astronave (Glider)
        game.setCell(1, 0, 1);
        game.setCell(2, 1, 1);
        game.setCell(0, 2, 1);
        game.setCell(1, 2, 1);
        game.setCell(2, 2, 1);

        // Configurazione di un blocco stabile
        game.setCell(20, 20, 1);
        game.setCell(20, 21, 1);
        game.setCell(21, 20, 1);
        game.setCell(21, 21, 1);

        // Configurazione di un altro oscillatore (Blinker)
        game.setCell(5, 5, 1);
        game.setCell(5, 6, 1);
        game.setCell(5, 7, 1);

        // Configurazione di un altro astronave (Glider)
        game.setCell(10, 10, 1);
        game.setCell(11, 11, 1);
        game.setCell(9, 12, 1);
        game.setCell(10, 12, 1);
        game.setCell(11, 12, 1);

        // Configurazione di un'oscillatore complesso (Pulsar)
        int[][] pulsar = {
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0}
        };

        for (int row = 0; row < pulsar.length; row++) {
            for (int col = 0; col < pulsar[row].length; col++) {
                if (pulsar[row][col] == 1) {
                    game.setCell(5 + row, 5 + col, 1);
                }
            }
        }

        JFrame frame = new JFrame("Conway's Game of Life");
        Main panel = new Main(game);
        frame.add(panel);
        frame.setSize(520, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            game.nextGeneration();
            panel.repaint();
            Thread.sleep(300);
        }
    }
}