import java.util.ArrayList;
import java.util.List;

class D08P1 {
    public static void main (String[] args) {
        List<String> lines = new ArrayList<String>();
        lines = Aoc.startUp(args);
        
        // Initializing the screen instance.
        Screen s = new Screen(50, 6);
        
        // Looping through each line and parsing command.
        for (String line : lines) {
            String[] command = line.split(" ");
            if (command.length > 0) {
                if (command[0].equals("rect")) {
                    String[] coords = command[1].split("x");
                    s.rect(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
                }
                else if (command[0].equals("rotate")) {
                    int a = Integer.parseInt(command[2].split("=")[1]);
                    int b = Integer.parseInt(command[4]);
                    if (command[1].equals("row")) {
                        s.rotateRow(a, b);
                    }
                    else if (command[1].equals("column")) {
                        s.rotateColumn(a, b);
                    }
                }
            }
        }
        
        System.out.println(s.toString());
        System.out.println("Number of pixels lit: " + s.numPixelsLit());
    }
}
