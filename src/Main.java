import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SpaceSearcher searcher = new SpaceSearcher(15);

        long start = System.currentTimeMillis();
        State result = searcher.BeamSearch(500, 1000);
        long end = System.currentTimeMillis();

        if ( result == null) System.out.println("Solution not found");
        else result.print();
        System.out.println("Search time: " + (double) (end - start) / 1000 + " seconds.");
    }
}
