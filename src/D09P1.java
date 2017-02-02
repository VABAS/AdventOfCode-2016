import java.util.ArrayList;
import java.util.List;

class D09P1 {
    private static String decompress (String input) {
        String decompressed = "";
        String markerString = "";
        int numChars = 0;
        int repeatn  = 0;
        boolean marker = false;
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (input.charAt(i) == '(') {
                marker = true;
            }
            else if (input.charAt(i) == ')') {
                numChars = Integer.parseInt(markerString.split("x")[0]);
                repeatn = Integer.parseInt(markerString.split("x")[1]);
                for (int j = 0; j < repeatn; j++) {
                    decompressed += input.substring(i + 1, i + numChars + 1);
                }
                i += numChars;
                markerString = "";
                marker = false;
            }
            else if (marker) {
                markerString += input.charAt(i);
            }
            else {
                decompressed += input.charAt(i);
            }
        }
        return decompressed;
    }
    
    public static void main (String[] args) {
        List<String> lines = new ArrayList<String>();
        lines = Aoc.startUp(args);
        
        for (String line : lines) {
            if (line.length() > 0) {
                System.out.println(decompress(line).length());
            }
        }
    }
}
