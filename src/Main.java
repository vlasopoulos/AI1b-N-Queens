public class Main {
    public static void main(String[] args) {
        int n = 8;
        int k = 20;
        int maxIterations = 500;

        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }
        if (args.length == 2){
            n = Integer.parseInt(args[0]);
            k = Integer.parseInt(args[1]);
        }
        if (args.length == 3){
            n = Integer.parseInt(args[0]);
            k = Integer.parseInt(args[1]);
            maxIterations = Integer.parseInt(args[2]);
        }

        SpaceSearcher searcher = new SpaceSearcher(n);

        long start = System.currentTimeMillis();
        State result = searcher.BeamSearch(k, maxIterations);
        long end = System.currentTimeMillis();

        if (result == null) System.out.println("Solution not found");
        else result.print();
        System.out.println("Search time: " + (double) (end - start) / 1000 + " seconds.");
    }
}
