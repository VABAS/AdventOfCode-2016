import java.util.List;
import java.util.ArrayList;

class D07P1 {
    // Method to check if string is ABBA. String must be four characters long.
    private static boolean isAbba (String input) {
        if (input.charAt(0) == input.charAt(3) &&
            input.charAt(1) == input.charAt(2) &&
            input.charAt(0) != input.charAt(1)) {
            return true;
        }
        return false;
    }

    private static boolean supportsTls (String input) {
        boolean abbaFound = false;
        boolean isInsideBrackets = false;
        String tempString = "";

        for (char c : input.toCharArray()) {
            if (c == '[') {
                tempString = "";
                isInsideBrackets = true;
            }
            else if (c == ']') {
                tempString = "";
                isInsideBrackets = false;
            }
            else {
                tempString += c;
                if (tempString.length() > 4) {
                    tempString = tempString.substring(1, 5);
                }
            }

            if (tempString.length() == 4) {
                // Checking for ABBA.
                if (isAbba(tempString)) {
                    if (isInsideBrackets) {
                        return false;
                    }
                    abbaFound = true;
                }
            }
        }
        return abbaFound;
    }

    public static void main (String[] args) {
        List<String> lines = Aoc.startUp(args);
        int counter = 0;
        for (String line : lines) {
            if (supportsTls(line)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
