package Game;

/**
 * Created by User on 29.02.2016.
 */
abstract class Tile {
    int[] fields = new int[4];
    Board board;
    String color;

    Tile(Board board) {
        this.board = board;
    }

    abstract void setFields();
    abstract void rotateLeft();
    abstract void rotateRight();

    void setFieldsOnBoard() {
        for (int i=0; i<fields.length; i++) {
            board.getField(fields[i]).makePartOfTile(color);
        }
    }

    void moveLeft() {
        if (isAbleToMoveLeft()) {
            emptyOldFields();
            movePointersLeft();
            setFieldsOnBoard();
        }
    }

    boolean isAbleToMoveLeft() {
        for (int i=0; i<fields.length; i++) {
            if (!board.getField(fields[i]).isAbleToMoveLeft())
                return false;
        }
        return true;
    }

    void emptyOldFields() {
        for (int i=0; i<fields.length; i++) {
            board.getField(fields[i]).empty();
        }
    }

    void movePointersLeft() {
        for (int i=0; i<fields.length; i++) {
            fields[i]--;
        }
    }

    void moveRight() {
        if (isAbleToMoveRight()) {
            emptyOldFields();
            movePointersRight();
            setFieldsOnBoard();
        }
    }

    boolean isAbleToMoveRight() {
        for (int i=0; i<fields.length; i++) {
            if (!board.getField(fields[i]).isAbleToMoveRight())
                return false;
        }
        return true;
    }

    void movePointersRight() {
        for (int i=0; i<fields.length; i++) {
            fields[i]++;
        }
    }

    void fall() {
        if (isFallPossible()) {
            emptyOldFields();
            movePointerDown();
            setFieldsOnBoard();
        }
    }

    boolean isFallPossible() {
        for (int i=0; i<fields.length; i++) {
            if (!board.getField(fields[i]).isFallPossible())
                return false;
        }
        return true;
    }

    void movePointerDown() {
        for (int i=0; i<fields.length; i++) {
            fields[i] += 10;
        }
    }

    boolean isAbleToRotate(int[] temp) {
        for (int i=0; i<fields.length; i++) {
            if (!board.getField(fields[i]).isPositionEmpty(temp[i]))
                return false;
        }
        return true;
    }

    void movePointers(int[] temp) {
        for (int i=0; i<fields.length; i++) {
            fields[i] = temp[i];
        }
    }

    boolean isVertical() {
        return Math.abs(fields[0] - fields[1]) == 10;
    }
}

class iShapeTile extends Tile {
    iShapeTile(Board board) {
        super(board);
        color = "RED";
    }

    @Override
    void setFields() {
        fields[0] = 4;
        fields[1] = 14;
        fields[2] = 24;
        fields[3] = 34;
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {
        int[] temp = new int[4];
        rotationLeftPointers(temp);
        if (isAbleToRotate(temp)) {
            emptyOldFields();
            movePointers(temp);
            setFieldsOnBoard();
        }
    }

    void rotationLeftPointers(int[] temp) {
        if (isVertical())
            for (int i=0; i< fields.length; i++)
                temp[i] = fields[1] + ((fields[i] - fields[1]) / 10);
        else
            for (int i=0; i< fields.length; i++)
                temp[i] = fields[1] - ((fields[i] - fields[1]) * 10);
    }

    @Override
    void rotateRight() {
        int[] temp = new int[4];
        rotationRightPointers(temp);
        if (isAbleToRotate(temp)) {
            emptyOldFields();
            movePointers(temp);
            setFieldsOnBoard();
        }
    }

    void rotationRightPointers(int[] temp) {
        if (isVertical())
            for (int i=0; i< fields.length; i++)
                temp[i] = fields[1] - ((fields[i] - fields[1]) / 10);
        else
            for (int i=0; i< fields.length; i++)
                temp[i] = fields[1] + ((fields[i] - fields[1]) * 10);
    }
}

class oShapeTile extends Tile {
    oShapeTile(Board board) {
        super(board);
        color = "BLUE";
    }

    @Override
    void setFields() {
        fields[0] = 4;
        fields[1] = 5;
        fields[2] = 14;
        fields[3] = 15;
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {
        //rotation doesn't change a thing
    }

    @Override
    void rotateRight() {
        //rotation doesn't change a thing
    }
}

class tShapeTile extends Tile {
    tShapeTile(Board board) {
        super(board);
        color = "YELLOW";
    }

    @Override
    void setFields() {
        fields[0] = 4;
        fields[1] = 5;
        fields[2] = 6;
        fields[3] = 15;
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {
        int[] temp = new int[4];
        rotationLeftPointers(temp);
        if (isAbleToRotate(temp)) {
            emptyOldFields();
            movePointers(temp);
            setFieldsOnBoard();
        }
    }

    void rotationLeftPointers(int[] temp) {
        if (isVertical()) {
            temp[0] = fields[3];
            temp[1] = fields[1];
            temp[3] = fields[2];
            temp[2] = fields[1] + ((fields[2] - fields[1]) / 10);
        }
        else {
            temp[0] = fields[3];
            temp[1] = fields[1];
            temp[3] = fields[2];
            temp[2] = fields[1] + ((fields[2] - fields[1]) * -10);
        }
    }

    @Override
    void rotateRight() {
        int[] temp = new int[4];
        rotationRightPointers(temp);
        if (isAbleToRotate(temp)) {
            emptyOldFields();
            movePointers(temp);
            setFieldsOnBoard();
        }
        rotationRightPointers(temp);
    }

    void rotationRightPointers(int[] temp) {
        if (isVertical()) {
            temp[1] = fields[1];
            temp[2] = fields[3];
            temp[3] = fields[0];
            temp[0] = fields[1] + ((fields[0] - fields[1]) / -10);
        }
        else {
            temp[1] = fields[1];
            temp[2] = fields[3];
            temp[3] = fields[0];
            temp[0] = fields[1] + ((fields[0] - fields[1]) * 10);
        }
    }
}

class lShapeTile extends Tile {
    lShapeTile(Board board) {
        super(board);
        color = "PINK";
    }

    @Override
    void setFields() {
        fields[0] = 4;
        fields[1] = 14;
        fields[2] = 24;
        fields[3] = 25;
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {
        if(isVertical()) {

        }
        else {

        }
    }

    @Override
    void rotateRight() {

    }
}

class jShapeTile extends Tile {

    jShapeTile(Board board) {
        super(board);
        color = "GREEN";
    }

    @Override
    void setFields() {
        fields[0] = 5;
        fields[1] = 15;
        fields[2] = 24;
        fields[3] = 25;
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {

    }

    @Override
    void rotateRight() {

    }
}

class sShapeTile extends Tile {
    sShapeTile(Board board) {
        super(board);
        color = "GRAY";
    }

    @Override
    void setFields() {
        fields[0] = 4;
        fields[1] = 14;
        fields[2] = 15;
        fields[3] = 25;
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {

    }

    @Override
    void rotateRight() {

    }
}

class zShapeTile extends Tile {
    zShapeTile(Board board) {
        super(board);
        color = "ORANGE";
    }

    @Override
    void setFields() {
        fields[0] = 5;
        fields[1] = 14;
        fields[2] = 15;
        fields[3] = 24;
        setFieldsOnBoard();
    }

    @Override
    void rotateLeft() {

    }

    @Override
    void rotateRight() {

    }
}