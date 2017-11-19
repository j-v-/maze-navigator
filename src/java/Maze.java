import java.util.*;

/**
 * @author jeavydsouza on 15/11/2017.
 */
public class Maze {
    private int start_col;
    private int start_row;
    private int dest_col;
    private int dest_row;
    private int width;
    private int height;
    private Node[][] maze;

    public Maze(List<String> maze_lines){
        for(int i = 0; i < maze_lines.size(); i++){
            switch (i){
                case 0:
                    String[] inputs = maze_lines.get(i).split(" ");
                    this.width = Integer.parseInt(inputs[0]);//Columns
                    this.height = Integer.parseInt(inputs[1]);//Rows
                    break;
                case 1:
                    setStart_pos(maze_lines.get(i));
                    break;
                case 2:
                    setDest_pos(maze_lines.get(i));
                    break;
                case 3:
                    setMaze(maze_lines.subList(i, maze_lines.size()));
                    return;
            }
        }
    }


    public void setMaze(List<String> maze_list){
        //System.out.println(maze_list.toString());
        this.maze = new Node[this.height][this.width];
        for(int row = 0; row < this.height; row++){
            String[] columns = maze_list.get(row).split(" ");
            for (int col = 0; col < columns.length; col++){
                this.maze[row][col] = new Node(row, col, columns[col].trim());
            }
        }
    }

    public void printMaze(){
        System.out.println("Start -> " + getStartCol() + ", " + getStartRow());
        System.out.println("Dest -> " + getDestCol() + ", " + getDestRow());
        for (int row = 0; row < this.height; row++){
            for(int col = 0; col < this.width; col++){
                System.out.print(getNode(row, col).isFree()? "0" : "1");
                System.out.print("");
            }
            System.out.println();
        }
    }

    public void printMazeWithPath(Path path){
        Node source = path.getPath().getFirst();
        Node destination = path.getPath().getLast();
        for (int row = 0; row < this.height; row++){
            for(int col = 0; col < this.width; col++){
                if(isDestination(row, col))
                    System.out.print("E");
                else if(isSource(row, col))
                    System.out.print("S");
                else if(path.isInPath(row, col))
                    System.out.print("X");
                else if(row == 0 || col == 0 || row == this.height-1 || col == this.width-1)
                    System.out.print("#");
                else
                    System.out.print(getNode(row, col).isFree()? " " : "#");
                System.out.print("");
            }
            System.out.println();
        }
    }

    /**
     * Sets travel directions for each free node
     */
    public void setNavigableMaze(){
        for (int row = 0; row < this.height; row++){
            for(int col = 0; col < this.width; col++){
                //System.out.println(x + ", " + y + " -> " + getNode(x, y).isFree());
                Node node = getNode(row, col);
                if(!node.isFree())
                    continue;
                node.setLeft(isLeft(row, col, -1));
                node.setRight(isRight(row, col, 1));
                node.setUp(isUp(row, col, -1));
                node.setDown(isDown(row, col, 1));
            }
        }
    }

    public boolean isLeft(int row, int col, int d){ return isSafe(row, col + d); }

    public boolean isRight(int row, int col, int d){
        return isSafe(row, col + d);
    }

    public boolean isUp(int row, int col, int d){
        return isSafe(row + d, col);
    }

    public boolean isDown(int row, int col, int d){
        return isSafe(row + d, col);
    }

    public boolean isSafe(int row, int col){
        if(row < this.height && col < this.width && row >= 0 && col >= 0)
            return getNode(row, col).isFree();
        return false;
    }

    public Node getNode(int row, int col){
        return this.maze[row][col];
    }

    public Node[][] getMaze() {
        return maze;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStart_pos(String start_pos) {
        String[] inputs = start_pos.split(" ");
        this.start_col = Integer.parseInt(inputs[0]);
        this.start_row = Integer.parseInt(inputs[1]);
    }

    public void setDest_pos(String dest_pos) {
        String[] inputs = dest_pos.split(" ");
        this.dest_col = Integer.parseInt(inputs[0]);
        this.dest_row = Integer.parseInt(inputs[1]);
    }

    public boolean isDestination(int row, int col){
        if(row == getDestRow() && col == getDestCol())
            return true;
        return false;
    }

    public boolean isSource(int row, int col){
        if(row == getStartRow() && col == getStartCol())
            return true;
        return false;
    }

    public int getStartCol() {
        return start_col;
    }

    public void setStartCol(int start_col) {
        this.start_col = start_col;
    }

    public int getStartRow() {
        return start_row;
    }

    public void setStartRow(int start_row) {
        this.start_row = start_row;
    }

    public int getDestCol() {
        return dest_col;
    }

    public void setDestCol(int dest_col) {
        this.dest_col = dest_col;
    }

    public int getDestRow() {
        return dest_row;
    }

    public void setDestRow(int dest_row) {
        this.dest_row = dest_row;
    }
}
