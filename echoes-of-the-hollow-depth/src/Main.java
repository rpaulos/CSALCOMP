import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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

                    int[] orderVisited = (visitedChambers(passages, m, startingChamber));

                    for (int num : orderVisited) {
                        System.out.print(num + " ");
                    }

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
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] passage : passages) {
            // Add both directions since passages are bidirectional
            graph.computeIfAbsent(passage[0], k -> new ArrayList<>()).add(passage[1]);
            graph.computeIfAbsent(passage[1], k -> new ArrayList<>()).add(passage[0]);
        }

        for (List<Integer> neighbors : graph.values()) {
            Collections.sort(neighbors);
        }

        List<Integer> visited = new ArrayList<>();       
        Set<Integer> visitedSet = new HashSet<>();       

        dfs(startingChamber, graph, visited, visitedSet);

        int[] result = new int[visited.size()];
        for (int i = 0; i < visited.size(); i++) {
            result[i] = visited.get(i);
        }
        return result;

    }

    private static void dfs(int node, Map<Integer, List<Integer>> graph, List<Integer> visited, Set<Integer> visitedSet) {
        if (visitedSet.contains(node)) return;
    
        visitedSet.add(node);
        visited.add(node);
    
        List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
        for (int neighbor : neighbors) {
            dfs(neighbor, graph, visited, visitedSet);
        }
    }
}
