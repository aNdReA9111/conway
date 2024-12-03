
package conway;

public class DeadStateStrategy implements StateStrategy {
    public int nextState(int neighbors) {
        return new StateTransition(neighbors, 3).getNextState();
    }
}