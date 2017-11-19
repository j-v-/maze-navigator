/**
 * @author jeavydsouza on 15/11/2017.
 */
public class Node {
    private int row;
    private int col;
    private boolean isFree;
    private boolean isVisited;
    private boolean isTraversable;

    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;

    public Node(int row, int col, String is_free){
        this.row = row;
        this.col = col;
        this.isFree = is_free.equals("0") ? true : false;
        this.isVisited = false;
        this.isTraversable = true;
    }

    public boolean isSame(Node other){
        if(this.row == other.getRow() && this.col == other.getCol())
            return true;
        return false;
    }
    public boolean isFree(){
        return isFree;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public boolean isTraversable() {
        return isTraversable;
    }

    public void setTraversable(boolean isLeft, boolean isRight, boolean isUp, boolean isDown){
        if (isLeft || isRight || isUp || isDown)
            isTraversable = true;
        else
            isTraversable = false;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
