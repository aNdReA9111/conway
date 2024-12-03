
package conway;

public class DeadState implements CellState {
    public int nextState(int neighbors) {
        return new DeadStateStrategy().nextState(neighbors);
    }
}