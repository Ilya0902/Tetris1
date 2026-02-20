import java.util.ArrayList;
import java.util.List;

public class Figure {

    private final  FigureType type;
    private final int rotation;
    private final int x;
    private final int y;

    public Figure(FigureType type, int rotation, int x, int y) {
        this.type = type;
        this.rotation = rotation;
        this.x = x;
        this.y = y;
    }

    public List<Point> getAbsoluteBloks() {
        List<Point> blocks = new ArrayList<>();

        Point[] shape = type.states[rotation];
        for(Point p: shape){
            blocks.add(new Point(
                    x + p.x,
                    y + p.y
            ));
        }
        return blocks;
    }

    public FigureType getType() {
        return type;
    }

    public int getRotation() {
        return rotation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
