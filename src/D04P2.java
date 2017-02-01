import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class D04P2 extends D04P1 {
    private static String decrypt (String cipher, int key) {
        char[] alphapets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        while (key >= alphapets.length) {
            key -= alphapets.length;
        }
        String clearText = "";
        for (char c : cipher.toCharArray()) {
            if (c == '-') {
                clearText += " ";
            }
            else {
                // Finding correct alphapet for current character.
                for (int i = 0; i < alphapets.length; i++) {
                    if (alphapets[i] == c) {
                        int charKey = key + i;
                        if (charKey >= alphapets.length) {
                            charKey -= alphapets.length;
                        }
                        clearText += alphapets[charKey];
                        break;
                    }
                }
            }
        }
        // Stripping space which is always last character here.
        clearText = clearText.substring(0, clearText.length() - 1);
        return clearText;
    }
    // Main.
    public static void main (String[] args) {
        List<String> lines = new ArrayList<String>();
        lines = Aoc.startUp(args);

        // System.out.println(decrypt("qzmt-zixmtkozy-ivhz", 343));
        // System.exit(0);
        for (String line : lines) {
            int sectorId = sectorIfReal(line);
            if (sectorId > 0) {
                String roomName = decrypt(line.split("\\[")[0], sectorId);
                if (roomName.matches("(.*)north(.*)pole(.*)object(.*)")) {
                    System.out.println(sectorId + " (" + roomName + ")");
                    break;
                }
            }
        }
    }
}
