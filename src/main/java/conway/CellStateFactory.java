
package conway;

public class CellStateFactory {
    public static CellState getState(int state) {
        return state == 1 ? new AliveState() : new DeadState();
    }
}