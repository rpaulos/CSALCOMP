import java.util.Scanner;

public class CandyGenerator {
    Scanner scanner = new Scanner(System.in);

    public void generateCandy() {
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        int n = Integer.parseInt(parts[0]); // Number of children
        int k = Integer.parseInt(parts[1]); // Maximum number for the favorite candy

        if ((1 <= n && n <= 100) && (1 <= k && k <= 100)) {
            int[] candies = new int[n];

            System.out.println("Enter " + n + " favorite candy numbers:");

            String favorite_candies = scanner.nextLine();
            String[] favorite_candy_parts = favorite_candies.split(" ");

            int[] favorite_candy_numbers = new int[favorite_candy_parts.length];

            if (favorite_candy_parts.length <= k) {
                //logic if length of favorite_candy_parts is less than or equal to k

                for (int i = 0; i <= n; i++) {
                    // Convert each part to an integer and store it in the array
                    favorite_candy_numbers[i] = Integer.parseInt(favorite_candy_parts[i]);

                    for (int j = 0; j <= n; j++) {
                        
                        if (favorite_candy_numbers[j] > k ) {
                            //increment the favorite_candy_numbers if it is less than the maximum fav candy number
                            favorite_candy_numbers[j] = favorite_candy_numbers[j] + 1;
                        } else {
                            //set the favorite_candy_numbers to 1 if it is already the maximum fav candy number
                            favorite_candy_numbers[j] = favorite_candy_numbers[j] = 1;
                        }
                    }
                }
            } else {
                //logic if length of favorite_candy_parts is greater than k
            }
        } else {
            System.out.println("Invalid input. Please input numbers between 1 and 100");
        }
    }
}
