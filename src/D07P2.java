import java.util.List;
import java.util.ArrayList;

class D07P2 {
    // Checks whetever the provided string is ABA. It must be three characters
    // long.
    private static boolean isAba (String input) {
        if (input.charAt(0) == input.charAt(2) &&
            input.charAt(0) != input.charAt(1)) {
            return true;
        }
        return false;
    }
    
    private static boolean isBababMatch (String aba, String bab) {
        if (isAba(aba) && isAba(bab) &&
            bab.charAt(0) == aba.charAt(1) &&
            bab.charAt(1) == aba.charAt(0)) {
            return true;
        }
        return false;
    }
    
    private static boolean supportsSsl (String input) {
        boolean isInsideBrackets = false;
        String tempString = "";
        List<String> aba = new ArrayList<String>();
        List<String> bab = new ArrayList<String>();

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
                if (tempString.length() > 3) {
                    tempString = tempString.substring(1, 4);
                }
            }

            if (tempString.length() == 3) {
                // Checking for ABA.
                //if (isAba(tempString)) {
                    if (isInsideBrackets) {
                        bab.add(tempString);
                    }
                    else {
                        aba.add(tempString);
                    }
                //}
            }
        }
        
        for (String s : aba) {
            for (String ss : bab) {
                if (isBababMatch(s, ss)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main (String[] args) {
        List<String> lines = Aoc.startUp(args);
        int counter = 0;
        for (String line : lines) {
            if (supportsSsl(line)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
