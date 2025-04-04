import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        int n = 0, k = 0;

        try {
            n = Integer.parseInt(parts[0]); // Number of children
            k = Integer.parseInt(parts[1]); // Maximum number for the favorite candy    
        } catch (NumberFormatException e) {
            System.out.println("Invalid nput. Please enter numeric characters only");
            scanner.close();
            return;
        }

        if ((1 <= n && n <= 100) && (1 <= k && k <= 100)) {

            String favorite_candies = scanner.nextLine();
            String[] favorite_candy_parts = favorite_candies.split(" ");

            if (favorite_candy_parts.length == n) {
                int[] favorite_candy_numbers = new int[n];

                for (int i = 0; i < n; i++) {
                    try {
                        // Convert each part to an integer and store it in the array
                        favorite_candy_numbers[i] = Integer.parseInt(favorite_candy_parts[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter numeric characters only");
                        scanner.close();
                        return;
                    }
                }

                for (int j = 0; j < n; j++) {    
                    if (favorite_candy_numbers[j] < k ) {
                        //increment the favorite_candy_numbers if it is less than the maximum fav candy number
                        favorite_candy_numbers[j] = favorite_candy_numbers[j] + 1;
                    } else {
                        //set the favorite_candy_numbers to 1 if it is already the maximum fav candy number
                        favorite_candy_numbers[j] = 1;
                    }
                }

                for (int num : favorite_candy_numbers) {
                    System.out.print(num + " ");
                }

            } else {
                System.out.println("Invalid number of favorite candies. Please input " + n + " numbers.");
            }

        } else {
            System.out.println("Invalid input. Please input numbers between 1 and 100");
        }
        scanner.close();
    }
}