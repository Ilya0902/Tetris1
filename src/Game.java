import java.util.List;

public class Game {

    private final Field field;
    private Figure currentFigure;

    public Game() {
        this.field = new Field(10,20);
        spawnNewFigure();
    }

    public boolean canPlace(Figure figure) {
        List<Point> coordinates = figure.getAbsoluteBloks();
        for (Point p : coordinates) {
            if (!field.isInside(p.x, p.y)) {
                return false;
            }
            if (!field.isEmpty(p.x, p.y)) {
                return false;
            }
        }
        return true;
    }


    public boolean tryMove(int dx, int dy) {
        Figure movedFigure = new Figure(
                currentFigure.getType(),
                currentFigure.getRotation(),
                currentFigure.getX() + dx,
                currentFigure.getY() + dy
        );
        if(canPlace(movedFigure)) {
            currentFigure = movedFigure;
            return true;
        }
        return false;
    }

    public boolean tryMoveDown() {
       return tryMove(0,-1);
    }
    public boolean tryMoveLeft() {
        return tryMove(-1, 0);
    }
    public boolean tryMoveRight() {
        return tryMove(1,0);
    }

    public boolean tryRotate() {
        int nextRotation = (currentFigure.getRotation() +1 )% currentFigure.getType().states.length;
        Figure rotatedFigure = new Figure(
                currentFigure.getType(),
                nextRotation,
                currentFigure.getX(),
                currentFigure.getY()
        );
        if(canPlace(rotatedFigure)) {
            currentFigure = rotatedFigure;
            return true;
        }
        return false;
    }

    public void spawnNewFigure() {
        FigureType[] types = FigureType.values();
        FigureType randomType = types[(int) (Math.random()*types.length)];
        int x = field.getWidth() / 2 - 1;
        int y = field.getHeight() - 1;
        int rotation = 0;
        currentFigure = new Figure(randomType,rotation,x,y);
    }

    public boolean gameOver() {
        if(!canPlace(currentFigure)){
            return true;
        }
        if (currentFigure == null){
            return false;
        }
        return false;
    }

    public void tick() {
        if(currentFigure == null){
            spawnNewFigure();;
        }
        if(!tryMoveDown()) {
            field.placeFigure(currentFigure);
            field.clearFullLines();
            spawnNewFigure();
        }
    }

    public void printField() {
        List<Point> active = currentFigure == null ? List.of() : currentFigure.getAbsoluteBloks();

        for (int y = field.getHeight() - 1; y >= 0; y--) {
            for (int x = 0; x < field.getWidth(); x++) {

                boolean isActiveBlock = false;
                for (Point p : active) {
                    if (p.x == x && p.y == y) {
                        isActiveBlock = true;
                        break;
                    }
                }

                if (field.getCell(x, y) == 1) {
                    System.out.print("# ");
                } else if (isActiveBlock) {
                    System.out.print("@ ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("------------");
    }
}
