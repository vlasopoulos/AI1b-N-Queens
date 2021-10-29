import java.util.ArrayList;
import java.util.Collections;

public class SpaceSearcher {

    private int dimension;
    private ArrayList<State> states;

    SpaceSearcher(int n) {
        this.dimension = n;
        states = new ArrayList<>();
    }

    State BeamSearch(int k, int maxIterations) { //k = beam nodes amount
        for (int i = 0; i < k; i++) {
            states.add(new State(dimension));
        }

        ArrayList<State> childStates = new ArrayList<>();
        for (int i = 0; i < maxIterations; i++) {

            while (states.size() > 0) {
                State currentState = states.remove(0);
                if (currentState.isFinal()) return currentState;
                childStates.addAll(currentState.getChildren());
            }

            Collections.sort(childStates);
            states.clear();

            //an exoume kolisei se local minima add random states in childStates
            if (childStates.size() == 0) {
                for (int j = 0; j < k; j++) {
                    childStates.add(new State(dimension));
                }
            }

            if (childStates.size() < k) {
                states.addAll(childStates);
            } else {
                states.addAll(childStates.subList(0, k));
            }
            childStates.clear();
        }

        return null;
    }
}
