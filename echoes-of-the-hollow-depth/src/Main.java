import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String[] parts;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        if (parts.length > 2) {
            System.err.println("Maximum number of input is 2");
            scanner.close();

        } else if (parts.length < 2) {
            System.err.println("Minimum number of input is 2");
            scanner.close();

        } else {
            try {
                n = Integer.parseInt(parts[0]);
                m = Integer.parseInt(parts[1]);

                boolean valid = validateInputNM(n, m);

                if (valid) {
                    //get u and v
                    int[][] passages = (getPassages(n, m));

                    int startingChamber = scanner.nextInt();

                    int[] orderOfVisitedChambers = new int[m];

                    // System.out.println("Staring Chamber: " + startingChamber);
                    // System.out.println("Passages: " + Arrays.deepToString(passages));

                    int[] emelang = (visitedChamberss(passages, m, startingChamber));
                    System.out.println(Arrays.toString(emelang));

                } else {
                    scanner.close();
                    return;
                }

            } catch (NumberFormatException e) {
                System.err.println("Input should be a numeric character.");
            }
        }

    }

    public static boolean validateInputNM(int n, int m) {
        if (n < 2 || n > 100) {
            System.err.println("The value of n must be between 2 and 100");
            return false;
        }

        if (m < 1 || m > (n * (n - 1)) / 2) {
            System.err.println("The value of m must be between 1 and n * (n - 1) / 2");
            return false;
        }
        
        return true;
    }

    public static int[][] getPassages(int n, int m) {
        int[][] inputPassages = new int[m][2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < m; i++) {
            try {
                String input = scanner.nextLine();
                String[] parts = input.trim().split(" ");

                if (parts.length != 2) {
                    System.err.println("The minimum number of input for passages is two numbers");
                    i--;
                    continue;
                }

                inputPassages[i][0] = Integer.parseInt(parts[0]);
                inputPassages[i][1] = Integer.parseInt(parts[1]);

            } catch (NumberFormatException e) {
                System.err.println("Input should only contain numeric characters");
                i--;
            }
        }
        return inputPassages;
    }

    public static int[] visitedChambers(int[][] passages, int m, int startingChamber) {
    // Step 1: Build an adjacency list to represent the graph
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int[] passage : passages) {
        // Add both directions since passages are bidirectional
        graph.computeIfAbsent(passage[0], k -> new ArrayList<>()).add(passage[1]);
        graph.computeIfAbsent(passage[1], k -> new ArrayList<>()).add(passage[0]);
    }

    // Step 2: Sort each chamber's adjacency list so we prioritize smaller numbers first in DFS
    for (List<Integer> neighbors : graph.values()) {
        Collections.sort(neighbors);
    }

    // Step 3: Prepare data structures for DFS
    List<Integer> visited = new ArrayList<>();       // List to store the order of visited chambers
    Set<Integer> visitedSet = new HashSet<>();       // Set to track visited chambers and avoid cycles

    // Step 4: Perform DFS starting from the given chamber
    dfs(startingChamber, graph, visited, visitedSet);

    // Step 5: Convert the result list to an array and return
    int[] result = new int[visited.size()];
    for (int i = 0; i < visited.size(); i++) {
        result[i] = visited.get(i);
    }

    return result;
}

private static void dfs(int node, Map<Integer, List<Integer>> graph, List<Integer> visited, Set<Integer> visitedSet) {
    // Base case: if we've already visited this node, return
    if (visitedSet.contains(node)) return;

    // Mark the current node as visited
    visitedSet.add(node);
    visited.add(node);

    // Recursively visit all neighbors in ascending order
    List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
    for (int neighbor : neighbors) {
        dfs(neighbor, graph, visited, visitedSet);
    }
}
    
}
