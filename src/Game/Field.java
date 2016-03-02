package Game;

/**
 * Created by User on 24.02.2016.
 */
public class Field {
    final int height = 16;
    final int width = 10;
    boolean isPartOfTile;
    boolean isLocated;
    Board board;
    int position;
    String color;

    Field(Board board, int position) {
        this.board = board;
        this.position = position;
        isPartOfTile = false;
        isLocated = false;
    }

    void locate() {
        isPartOfTile = false;
        isLocated = true;
    }

    void makePartOfTile(String color) {
        this.color = color;
        isPartOfTile = true;
        isLocated = false;
    }

    void empty() {
        color = "";
        isPartOfTile = false;
        isLocated = false;
    }

    boolean isAbleToMoveLeft() {
        if (isFieldAtLeftBorder()) {
            return false;
        }
        return isLeftSideFieldEmpty();
    }

    boolean isFieldAtLeftBorder() {
        return (position == 0 || (position-1) % width > position % width);
    }

    boolean isLeftSideFieldEmpty() {
        return !board.getField(position-1).isLocated;
    }

    boolean isAbleToMoveRight() {
        if (isFieldAtRightBorder()) {
            return false;
        }
        return isRightSideFieldEmpty();
    }

    boolean isFieldAtRightBorder() {
        return (position+1) % width < position % width;
    }

    boolean isRightSideFieldEmpty() {
        return !board.getField(position+1).isLocated;
    }

    boolean isPositionEmpty(int pos) {
        return !board.getField(pos).isLocated;
    }

    void moveToPosition(int pos) {
        board.getField(pos).makePartOfTile(color);
        empty();
    }

    boolean isFallPossible() {
        return !(isFieldAtBottom() || isFieldBelowLocated());
    }

    boolean isFieldBelowLocated() {
        return board.getField(position+width).isLocated;
    }

    boolean isFieldAtBottom() {
        return position + width > (width * height)-1;
    }

    void fall() {
        board.getField(position+width).makePartOfTile(color);
        empty();
    }
}