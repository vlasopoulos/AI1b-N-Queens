import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
////        State state = new State(4);
//        int[] asd = {1,3,0,3};
//        State state = new State(4,asd);
//        state.print();
//
//        ArrayList<State> states = state.getChildren();
//        for (State s :
//                states) {
//            s.print();
//        }
        SpaceSearcher searcher = new SpaceSearcher(8);
        State result = searcher.BeamSearch(10, 500);
        if ( result == null) System.out.println("Solution not found");
        else result.print();
    }
}
