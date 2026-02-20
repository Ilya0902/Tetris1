public enum FigureType {

    //18.01 в этот день я перешел от матриц к координатам фигур

    I(new Point[][]{
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(2, 0),
                    new Point(3, 0)
            },
            {
                    new Point(0, 0),
                    new Point(0, -1),
                    new Point(0, -2),
                    new Point(0, -3)
            }
    }),

    O(new Point[][]{
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(0, -1),
                    new Point(1, -1)
            }
    }),

    T(new Point[][]{
            {
                    new Point(0, 0),
                    new Point(-1, 0),
                    new Point(1, 0),
                    new Point(0, -1)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, -1),
                    new Point(1, 0)
            },
            {
                    new Point(0, 0),
                    new Point(-1, 0),
                    new Point(1, 0),
                    new Point(0, 1)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, -1),
                    new Point(-1, 0)
            }
    }),

    S(new Point[][]{
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(0, -1),
                    new Point(-1, -1)
            },
            {
                    new Point(0, 0),
                    new Point(0, -1),
                    new Point(1, 0),
                    new Point(1, 1)
            }
    }),

    Z(new Point[][]{
            {
                    new Point(0, 0),
                    new Point(-1, 0),
                    new Point(0, -1),
                    new Point(1, -1)
            },
            {
                    new Point(0, 0),
                    new Point(0, -1),
                    new Point(-1, 0),
                    new Point(-1, 1)
            }
    }),

    L(new Point[][]{
            {
                    new Point(0, 0),
                    new Point(-1, 0),
                    new Point(1, 0),
                    new Point(1, -1)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, -1),
                    new Point(1, 1)
            },
            {
                    new Point(0, 0),
                    new Point(-1, 0),
                    new Point(1, 0),
                    new Point(-1, 1)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, -1),
                    new Point(-1, -1)
            }
    }),

    J(new Point[][]{
            {
                    new Point(0, 0),
                    new Point(-1, 0),
                    new Point(1, 0),
                    new Point(-1, -1)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, -1),
                    new Point(1, -1)
            },
            {
                    new Point(0, 0),
                    new Point(-1, 0),
                    new Point(1, 0),
                    new Point(1, 1)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, -1),
                    new Point(-1, 1)
            }
    });

    public final Point[][] states;

    FigureType(Point[][] states) {
        this.states = states;
    }
}

