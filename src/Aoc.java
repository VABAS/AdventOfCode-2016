import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;

public class Aoc {
    public static List<String> startUp (String[] args) {
        // Checking if there is enough args (input needed). Printing error if
        // not.
        if (args.length <= 0) {
            System.out.println("[ERROR] Not enough arguments!");
            System.out.println(" -- Input file is required");
            System.exit(0);
        }
        else if (args.length > 1) {
            System.out.println("[INFO] Too much arguments. Ignoring all but first...");
        }

        // Assigning input-file name.
        String inputFile = args[0];

        List<String> lines = new ArrayList<String>();

        // Reading file.
        try {
            lines = Files.readAllLines(Paths.get(inputFile), StandardCharsets.UTF_8);
        }
        catch (Exception e) {
            System.out.println("Exceptin occured.");
            System.exit(0);
        }
        return lines;

    }
}
