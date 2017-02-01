import java.util.List;
import java.util.ArrayList;

class D06P2 {
    private static char getLeastCommon (String input) {
        char leastCommon;
        int[] count = new int[input.length()];

        // Counting each caracter occurences using numChars-method implemented
        // at D04P1.
        for (int i = 0; i < input.length(); i++) {
            count[i] = D04P1.numChars(input.charAt(i), input);
        }

        // Checking which of the caracters occur most.
        leastCommon = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (count[i] < D04P1.numChars(leastCommon, input)) {
                leastCommon = input.charAt(i);
            }
        }
        return leastCommon;
    }

    public static void main (String[] args) {
        List<String> lines = new ArrayList<String>();
        lines = Aoc.startUp(args);

        List<String> characters = new ArrayList<String>();

        // Rotating columns to represent rows in our char array for easier
        // processing. Function from D06P1.
        characters = D06P1.columnsToRows(lines);

        // Printing most common character for each column.
        for (String c : characters) {
            System.out.print(getLeastCommon(c));
        }
        System.out.println();
    }
}
