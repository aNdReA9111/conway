
package conway;

public class AliveState implements CellState {
    public int nextState(int neighbors) {
        return new AliveStateStrategy().nextState(neighbors);
    }
}