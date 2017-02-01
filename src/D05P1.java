import java.util.List;
import java.util.ArrayList;
import java.security.MessageDigest;

class D05P1 {
    public static String calculatemd5 (String input) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        }
        catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e);
            System.exit(1);
        }
        md.update(input.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    private static String calculatePassword (String doorId) {
        String password = "";

        // Password length is always 8 characters.
        int index = 0;
        while (password.length() < 8) {
            String hash = calculatemd5(doorId + index);
            for (int j = 0; j < 6; j++) {
                if (j == 5) {
                    password += hash.charAt(5);
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
