package se.javierdlc.cardgame.states;


public class StateManager {
    private static State currentState = null;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State newState) {
        if (currentState != null) {
            currentState.terminate();
        }
        StateManager.currentState = newState;
        currentState.init();
    }
}
