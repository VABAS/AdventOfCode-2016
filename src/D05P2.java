

class D05P2 {

    private static char[] calculatePassword (String doorId) {
        // Initializing password to eight underscores for later checking.
        char[] password = "________".toCharArray();

        // Password length is always 8 characters.
        int index = 0;
        int lengthCounter = 0;
        while (lengthCounter < 8) {
            String hash = D05P1.calculatemd5(doorId + index);
            for (int j = 0; j < 6; j++) {
                if (j == 5) {
                    int numeric = Character.getNumericValue(hash.charAt(5));
                    if (numeric < 8) {
                        // If there is underscore in place we got, inserting
                        // character there. Otherwise ignoring as invalid
                        // position.
                        if (password[numeric] == '_') {
                            password[numeric] = hash.charAt(6);
                            lengthCounter++;
                        }
                    }
                    break;
                }
                else if (hash.charAt(j) != '0') {
                    break;
                }
            }
            index++;
        }
        return password;
    }

    public static void main (String[] args) {
        if (args.length >= 1) {
            System.out.println(calculatePassword(args[0]));
        }
        else {
            System.out.println("Not enough arguments.");
            System.out.println(" - Input must be specified.");
        }
    }
}
