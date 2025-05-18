public class AlphabetPyramid {
    public static void main(String[] args) {
        int rows = 5;
        char ch = 'A';

        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }

            // Print characters
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print(ch);
            }

            ch++; // Move to next alphabet
            System.out.println();
        }
    }
}
