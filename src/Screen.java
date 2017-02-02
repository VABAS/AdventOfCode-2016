class Screen {
    protected int width;
    protected int height;
    protected int[][] pixels;
    
    // Constructor. Requires width and height.
    public Screen (int w, int h) {
        this.pixels = new int[h][w];
        this.width  = w;
        this.height = h;
    }
    
    // Creates rectancle starting top left corner with width of a and height of
    // b.
    public void rect (int a, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                pixels[i][j] = 1;
            }
        }
    }
    
    // Rotates column a down by b pixels.
    public void rotateColumn (int a, int b) {
        int[] tempRow = new int[height];
        
        for (int i = 0; i < height; i++) {
            int shift = b;
            while (i + shift >= height) {
                shift -= height;
            }
            tempRow[i + shift] = pixels[i][a];
        }
        for (int i = 0; i < height; i++) {
            pixels[i][a] = tempRow[i];
        }
    }
    
    // Rotates row a right by b pixels.
    public void rotateRow (int a, int b) {
        int[] tempRow = new int[width];
        for (int i = 0; i < width; i++) {
            int shift = b;
            while (i + shift >= width) {
                shift -= width;
            }
            tempRow[i + shift] = pixels[a][i];
        }
        pixels[a] = tempRow;
    }
    
    // Counts number of pixels lit.
    public int numPixelsLit () {
        int count = 0;
        for (int[] row : pixels) {
            for (int pixel : row) {
                count += pixel;
            }
        }
        return count;
    }
    
    public String toString () {
        String str = "";
        for (int[] row : pixels) {
            for (int pixel : row) {
                if (pixel == 1) {
                    str += "#";
                }
                else {
                    str += " ";
                }
            }
            str += "\n";
        }
        return str;
    }
}
