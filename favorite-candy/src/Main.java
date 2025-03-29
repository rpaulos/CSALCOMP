import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of children: ");
        int n = scanner.nextInt(); //Number of children

        System.out.print("Enter the maximum number for the favorite candy: ");
        int k = scanner.nextInt(); //Maximum number for the favorite candy

        if ((1 <= n && n <= 100) && (1 <= k && k <= 100)) {
            int[] candies = new int[n];

            System.out.println("Enter " + n + " favorite candy numbers:");
            for (int i = 0; i < n; i++) {
                candies[i] = scanner.nextInt();
            }

            for (int j = 0; j < n; j++) {
                if (candies[j] < k) {
                    candies[j] = candies[j] + 1;
                } else {
                    candies[j] = 1;
                }
            }
            System.out.println("New favorite candy number: " + Arrays.toString(candies));
        
        } else {
            System.out.println("Invalid input. n and k must be between 1 and 100.");
        }
        scanner.close();
    
    }
}
