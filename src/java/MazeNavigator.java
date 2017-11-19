
/**
 * @author jeavydsouza on 15/11/2017.
 */
public class MazeNavigator {
    private static Path path;

    public boolean solveMaze(Maze maze){
        maze.setNavigableMaze();
        this.path = new Path();
        int dest_row = maze.getDestRow();
        int dest_col = maze.getDestCol();
        int curr_row = maze.getStartRow();
        int curr_col = maze.getStartCol();
        Node curr = maze.getNode(curr_row, curr_col);
        Node dest = maze.getNode(dest_row, dest_col);
        curr.setVisited(true);
        this.path.getPath().add(curr);
        path = traversePath(maze, curr, dest);
        if(!path.getPath().isEmpty()) {
            //System.out.println("Found path: ");
            //printPath();
            System.out.println("OUTPUT: ");
            path.setPath(path.pathWithoutLoops());
            maze.printMazeWithPath(path);
            return true;
        }
        System.out.println("OUTPUT: ");
        System.out.println("Unsolvable Maze - No path was found to destination.");
        return false;
    }

    public Path traversePath(Maze maze, Node curr, Node dest){
        //System.out.println("Current path: ");
        //printPath();
        if(maze.isDestination(curr.getRow(), curr.getCol()))
            return path;
        if(path.getPath().isEmpty())
            return path;

        Node new_pos = null;
        while (curr.isDown() && !(new_pos = moveDown(maze, curr)).isSame(curr)) {
            path.addPath(new_pos);
            return traversePath(maze, new_pos, dest);
        }
        while (curr.isRight() && !(new_pos = moveRight(maze, curr)).isSame(curr)) {
            path.addPath(new_pos);
            return traversePath(maze, new_pos, dest);
        }
        while (curr.isLeft() && !(new_pos = moveLeft(maze, curr)).isSame(curr)){
            path.addPath(new_pos);
            return traversePath(maze, new_pos, dest);
        }
        while (curr.isUp() && !(new_pos = moveUp(maze, curr)).isSame(curr)) {
            path.addPath(new_pos);
            return traversePath(maze, new_pos, dest);
        }
        // Pop path if new_pos is null return if path is empty
        if(new_pos == null && !path.getPath().isEmpty()) {
            path.getPath().removeLast();
            if(path.getPath().isEmpty())
                return path;
            return traversePath(maze, path.getPath().getLast(), dest);
        }

        return traversePath(maze, new_pos, dest);
    }

    public Node moveRight(Maze maze, Node curr){
        Node nextPos = maze.getNode(curr.getRow(), curr.getCol() + 1);
        if(nextPos.isFree() && nextPos.isTraversable()) {
            curr.setRight(false);
            curr.setTraversable(curr.isLeft(), curr.isRight(), curr.isUp(), curr.isDown());
            if(!curr.isTraversable())
                nextPos.setLeft(false);
            return nextPos;
        }
        return curr;
    }

    public Node moveLeft(Maze maze, Node curr){
        Node nextPos = maze.getNode(curr.getRow() , curr.getCol() - 1 ) ;
        if(nextPos.isFree() && nextPos.isTraversable()) {
            curr.setLeft(false);
            curr.setTraversable(curr.isLeft(), curr.isRight(), curr.isUp(), curr.isDown());
            if(!curr.isTraversable())
                nextPos.setRight(false);
            return nextPos;
        }
        return curr;
    }

    public Node moveUp(Maze maze, Node curr){
        Node nextPos = maze.getNode(curr.getRow() - 1, curr.getCol());
        if(nextPos.isFree() && nextPos.isTraversable()) {
            curr.setUp(false);
            curr.setTraversable(curr.isLeft(), curr.isRight(), curr.isUp(), curr.isDown());
            if(!curr.isTraversable())
                nextPos.setDown(false);
            return nextPos;
        }
        return curr;
    }

    public Node moveDown(Maze maze, Node curr){
        Node nextPos = maze.getNode(curr.getRow() + 1, curr.getCol());
        if(nextPos.isFree() && nextPos.isTraversable()) {
            curr.setDown(false);
            curr.setTraversable(curr.isLeft(), curr.isRight(), curr.isUp(), curr.isDown());
            if(!curr.isTraversable())
                nextPos.setUp(false);
            return nextPos;
        }
        return curr;
    }

    public void printPath(){
        for (Node node : path.getPath()){
            System.out.println(node.getRow() + ", " + node.getCol());
        }
    }
}
