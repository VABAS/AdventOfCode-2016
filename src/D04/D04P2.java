import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class D04P2 extends D04P1 {
    private static String decrypt (String cipher, int key) {
        char[] alphapets = 'abcdefghijklmnopqrstuwxyz';
        while (key >= alphapets.size()) {
            key -= alpapets.size();
        }
        String clearText = "";
        for (char c : cipher.toCharArray()) {
            if (c == '-') {
                clearText += " ";
            }
            else {
                clearText += c;
            }
        }
        return clearText;
    }
    // Main.
    public static void main (String[] args) {
        List<String> lines = new ArrayList<String>();
        lines = Aoc.startUp(args);
        
        for (String line : lines) {
            int sectorId = sectorIfReal(line);
            if (sectorId > 0) {
                System.out.println(decrypt(line.split("[")[0], sectorId) + ": " + sectorId);
            }
        }
    }
}
