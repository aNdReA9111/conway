
package conway;

public class AliveStateStrategy implements StateStrategy {
    public int nextState(int neighbors) {
        return new StateTransition(neighbors, 2, 3).getNextState();
    }
}