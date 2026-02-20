public class Field {
    private final int height;
    private final int width;
    private final int[][] cells;

    public Field(int width, int height) {
        this.height = height;
        this.width = width;
        this.cells = new int [height][width];
    }

    public boolean isInside(int x, int y) {
        return x >=0 && x <width && y >= 0 && y < height;
    }

    public boolean isEmpty(int x, int y) {
        if(!isInside(x,y)){
            return false;
        }
        return cells[y][x] == 0;
    }

    public void clearLine(int y) {
        for(int row = y; row > 0; row--){
            System.arraycopy(cells[row-1], 0, cells[row], 0, width);
        }
        for(int x = 0; x < width; x++) {
            cells[0][x] = 0;
        }
    }

    public int clearFullLines(){
        int cleared = 0;

        for(int y = 0;y < getHeight(); y++){
            if(isLineFull(y)) {
                clearLine(y);
                cleared++;
                y--;
            }
        }
        return cleared;
    }

    public boolean isLineFull(int y) {
        for(int x = 0; x < width;x++) {
            if(cells[y][x] ==0) {
                return false;
            }
        }
        return true;
    }

    public int getCell(int x, int y) {
        return cells[y][x];
    }

    public void placeFigure(Figure figure){
        for(Point block : figure.getAbsoluteBloks()){
            cells[block.y][block.x] = 1;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
