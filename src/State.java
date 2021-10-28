import java.util.ArrayList;
import java.util.Random;

public class State implements Comparable<State>{

    private int n;
    private int[] queenPositions;
    private int score;

    State(int n) {
        this.n = n;
        queenPositions = new int[n];
        this.randomize();
        this.setScore();
    }

    State (int n, int[] queenPositions){
        this.n = n;
        this.queenPositions = new int[n];
        for (int i = 0; i < n; i++) {
            this.queenPositions[i] = queenPositions[i];
        }
        this.setScore();
    }

    void randomize() {
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            queenPositions[i] = r.nextInt(n);
        }
    }

    int heuristic(int[] positions){
        int totalScore = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (positions[i] == positions[j]) totalScore++; // check same row threats
                if (Math.abs(i-j) == Math.abs(positions[i] - positions[j])) totalScore++; // check diagonal threats
            }
        }
        return totalScore;
    }

    public void setScore() {
        this.score = heuristic(queenPositions);
    }

    boolean isFinal(){
        return heuristic(queenPositions) == 0;
    }

    ArrayList<State> getChildren(){
        ArrayList<State> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            State child = new State(n, queenPositions);
            if (child.move(i)) {
                child.setScore();
                children.add(child); // an vroume kalitero skor kounontas vasilisa se ena column
            }
        }
        return children;
    }

    boolean move(int col){
        int initialHeuristic = heuristic(queenPositions);
        for (int i = 0; i < n; i++) {
            queenPositions[col] = i;
            if (heuristic(queenPositions) < initialHeuristic) return true;
        }
        return false;
    }

    void print(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queenPositions[j] == i) System.out.print("|Q");
                else System.out.print("| ");
            }
            System.out.println("|");
        }
    }

    @Override
    public int compareTo(State s) {
        return Integer.compare(this.score, s.score);
    }
}
