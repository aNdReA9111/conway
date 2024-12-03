
package conway;

public class StateTransition {
    private final int neighbors;
    private final int[] validCounts;

    public StateTransition(int neighbors, int... validCounts) {
        this.neighbors = neighbors;
        this.validCounts = validCounts;
    }

    public int getNextState() {
        return getNextStateRecursiveHelper(neighbors, validCounts, 0);
    }

    private int getNextStateRecursiveHelper(int neighbors, int[] validCounts, int index) {
        if (index >= validCounts.length)
            return 0;
        if (neighbors == validCounts[index])
            return 1;
        return getNextStateRecursiveHelper(neighbors, validCounts, index + 1);
    }
}