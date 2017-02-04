import java.util.ArrayList;
import java.util.List;

class D09P2 {
    // Returns decompressed length of string calculated from compressed value
    // provided. Uses long becouse int rolls around when there is very large
    // data decompressed.
    private static long getDecompressedLength (String input) {
        long length = 0;
        String markerString = "";
        List<Integer> numChars = new ArrayList<Integer>();
        List<Integer> repeatn = new ArrayList<Integer>();
        List<Integer> repeatStart = new ArrayList<Integer>();
        // Boolean to store marker value.
        boolean marker = false;
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (input.charAt(i) == '(') {
                marker = true;
            }
            else if (input.charAt(i) == ')') {
                // Adding repeat details to their own lists.
                numChars.add(Integer.parseInt(markerString.split("x")[0]));
                repeatn.add(Integer.parseInt(markerString.split("x")[1]));
                repeatStart.add(i);
                markerString = "";
                marker = false;
            }
            else if (marker) {
                markerString += input.charAt(i);
            }
            else {
                // Calculating amount to increase the length. Calculated by
                // multiplicating amount with each of the repeatamount-values
                // currently in effect.
                int amount = 1;
                for (int j = 0; j < numChars.size(); j++) {
                    if (numChars.get(j) + repeatStart.get(j) >= i) {
                        amount *= repeatn.get(j);
                    }
                }
                length += amount;
            }
        }
        return length;
    }

    public static void main (String[] args) {
        List<String> lines = new ArrayList<String>();
        lines = Aoc.startUp(args);
        
        for (String line : lines) {
            if (line.length() > 0) {
                System.out.println(getDecompressedLength(line));
            }
        }
    }
}
