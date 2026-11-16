
        System.out.println();

        System.out.println("=== Fewest Stops Route from Central to Airport ===");
        List<Integer> fewestStops = buildPath(dest, bfsPrev, start);
        printSummary("Fewest Stops", fewestStops);