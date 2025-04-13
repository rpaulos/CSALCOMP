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

                if (valid == true) {
                    //get u and v
                    int[][] passages = (getPassages(n, m));
                    System.out.println("Passages: " + Arrays.deepToString(passages));

                    //method to get u and v
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

 }
