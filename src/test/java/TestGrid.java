import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import conway.GameOfLife;

public class TestGrid {
    // Test per l'inizializzazione della griglia vuota
    @Test
    void testEmptyGridInitialization() {
        GameOfLife game = new GameOfLife(3, 3);
        int[][] expectedGrid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertArrayEquals(expectedGrid, game.getGrid());
    }

    // Test per un pattern complesso
    @Test
    void testComplexPattern() {
        GameOfLife game = new GameOfLife(5, 5);
        game.setCell(1, 2, 1);
        game.setCell(2, 2, 1);
        game.setCell(3, 2, 1);

        game.nextGeneration();

        int[][] expectedGrid = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        assertArrayEquals(expectedGrid, game.getGrid());
    }

    // Test per la morte per isolamento
    @Test
    void testUnderpopulation() {
        GameOfLife game = new GameOfLife(3, 3);
        game.setCell(1, 1, 1);  // Cella viva con meno di 2 vicini vivi

        game.nextGeneration();

        int[][] expectedGrid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        assertArrayEquals(expectedGrid, game.getGrid());
    }

    // Test per la morte per sovrappopolazione
    @Test
    void testOverpopulation() {
        GameOfLife game = new GameOfLife(3, 3);
        game.setCell(1, 1, 1);  // Cella viva con più di 3 vicini vivi
        game.setCell(0, 0, 1);
        game.setCell(0, 1, 1);
        game.setCell(0, 2, 1);
        game.setCell(1, 0, 1);
        game.setCell(1, 2, 1);

        game.nextGeneration();

        int[][] expectedGrid = {
            {1, 0, 1},
            {1, 0, 1},
            {0, 1, 0}
        };
        assertArrayEquals(expectedGrid, game.getGrid());
    }

    // Test per la riproduzione
    @Test
    void testReproduction() {
        GameOfLife game = new GameOfLife(3, 3);
        game.setCell(0, 1, 1);  // Cella morta con esattamente 3 vicini vivi
        game.setCell(1, 0, 1);
        game.setCell(1, 2, 1);

        game.nextGeneration();

        int[][] expectedGrid = {
            {0, 1, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        assertArrayEquals(expectedGrid, game.getGrid());
    }

    // Test per la sopravvivenza
    @Test
    void testSurvival() {
        GameOfLife game = new GameOfLife(3, 3);
        game.setCell(1, 1, 1);  // Cella viva con 2 vicini vivi
        game.setCell(0, 1, 1);
        game.setCell(2, 1, 1);

        game.nextGeneration();

        int[][] expectedGrid = {
            {0, 0, 0},
            {1, 1, 1},
            {0, 0, 0}
        };
        assertArrayEquals(expectedGrid, game.getGrid());
    }
}
