import java.util.List;
import java.util.ArrayList;

class D06P1 {
    private static char getMostCommon (String input) {
        char mostCommon;
        int[] count = new int[input.length()];

        // Counting each caracter occurences using numChars-method implemented
        // at D04P1.
        for (int i = 0; i < input.length(); i++) {
            count[i] = D04P1.numChars(input.charAt(i), input);
        }

        // Checking which of the caracters occur most.
        mostCommon = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (count[i] > D04P1.numChars(mostCommon, input)) {
                mostCommon = input.charAt(i);
            }
        }
        return mostCommon;
    }

    public static List<String> columnsToRows(List<String> rows) {
        List<String> columns = new ArrayList<String>();
        for (int i = 0; i < rows.size(); i++) {
            String currentLine = rows.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                if (i == 0) {
                    columns.add(Character.toString(currentLine.charAt(j)));
                }
                else {
                    columns.set(j, columns.get(j) + currentLine.charAt(j));
                }
            }
        }
        return columns;
    }

    public static void main (String[] args) {
        List<String> lines = new ArrayList<String>();
        lines = Aoc.startUp(args);

        List<String> characters = new ArrayList<String>();

        // Rotating columns to represent rows in our char array for easier
        // processing.
        characters = columnsToRows(lines);

        // Printing most common character for each column.
        for (String c : characters) {
            System.out.print(getMostCommon(c));
        }
        System.out.println();
    }
}
