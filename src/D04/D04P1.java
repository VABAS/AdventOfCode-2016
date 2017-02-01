import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class D04P1 {
    protected static int numDifferentChars (String word) {
        int num = 0;
        String found = "";
        for (char character : word.toCharArray()) {
            boolean doCount = true;
            for (char foundChar : found.toCharArray()) {
                if (foundChar == character) {
                    doCount = false;
                    break;
                }
            }

            if (doCount) {
                num++;
                found += character;
            }
        }
        return num;
    }
    protected static int numChars (char c, String word) {
        int counter = 0;
        for (char cc : word.toCharArray()) {
            if (cc == c) {
                counter++;
            }
        }
        return counter;
    }

    protected static int sectorIfReal (String name) {
        if (name.length() <= 0) {
            return 0;
        }
        String chars = "";

        boolean checkSumExpected = false;
        String checkSum = "";
        String sectorId = "";

        // Counting characters and extracting checksum.
        int numSections = name.split("-").length - 1;
        int sectionsCount = 0;
        for (int i = 0; i < name.length(); i++) {
            boolean found = false;
            if (name.charAt(i) == '-') {
                sectionsCount++;
            }
            else if (name.charAt(i) == '[') {
                checkSumExpected = true;
            }
            else if (checkSumExpected) {
                if (name.charAt(i) != ']') {
                    checkSum += name.charAt(i);
                }
                else {
                    break;
                }
            }
            else if (sectionsCount >= numSections) {
                sectorId += name.charAt(i);
            }
            else {
                chars += name.charAt(i);
            }
        }

        // Removing lowest occurences starting from bottom of the alphapets.
        char[] charsTemp = chars.toCharArray();
        Arrays.sort(charsTemp);
        chars = new String(charsTemp);
        while (numDifferentChars(chars) > 5) {
            int currentlySmallest = numChars(chars.charAt(0), chars);
            for (char c : chars.toCharArray()) {
                int cCount = numChars(c, chars);
                if (cCount < currentlySmallest) {
                    currentlySmallest = cCount;
                }
            }
            for (int i = chars.length() - 1; i >= 0; i--) {
                int count = numChars(chars.charAt(i), chars);
                if (count == currentlySmallest) {
                    chars = chars.replace(Character.toString(chars.charAt(i)), "");
                    break;
                }
            }
        }

        // Sorting by highest occurence and by alphapets. Saving generated
        // checksum to its own string.
        String generatedCheckSum = Character.toString(chars.charAt(0));
        for (int i = 0; i < chars.length(); i++) {
            if (numChars(chars.charAt(i), generatedCheckSum) <= 0) {
                if (numChars(generatedCheckSum.charAt(generatedCheckSum.length() - 1), chars) >= numChars(chars.charAt(i), chars)) {
                    generatedCheckSum += chars.charAt(i);
                }
                else {
                    for (int j = 0; j < generatedCheckSum.length(); j++) {
                        if (numChars(generatedCheckSum.charAt(j), chars) < numChars(chars.charAt(i), chars)) {
                            generatedCheckSum = generatedCheckSum.substring(0, j) +
                                                chars.charAt(i) +
                                                generatedCheckSum.substring(j, generatedCheckSum.length());
                            break;
                        }
                    }
                }
            }
        }

        // Checking checksum against generatedCheckSum. Returning sectorId if
        // they match and zero otherwise.
        if (checkSum.equals(generatedCheckSum)) {
            return Integer.parseInt(sectorId);
        }
        else {
            return 0;
        }
    }

    // Main.
    public static void main (String[] args) {
        List<String> lines = new ArrayList<String>();
        lines = Aoc.startUp(args);
        // Calculating the sum of sectorIds.
        int sum = 0;
        for (String line : lines) {
            sum += sectorIfReal(line);
        }
        System.out.println("Sum of valid sectorIds is " + sum);
    }
}
