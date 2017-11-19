import java.util.List;
import java.util.Scanner;

/**
 * @author jeavydsouza on 15/11/2017.
 */
public class MazeRunner {

    public static void main(String[] args){
        MazeRunner amaze = new MazeRunner();
        System.out.println(args.toString());
        if(args.length == 0){
            System.out.println("Please enter file location of the maze to navigate: ");
            Scanner sc = new Scanner(System.in);
            String filepath = sc.nextLine();
            amaze.solveMaze(filepath);
        }
       else {
            amaze.solveMaze(args[0]);
        }
    }

    public boolean solveMaze(String filepath){
        MazeInput mazeInput = new MazeInput();
        List<String> maze_str = mazeInput.readFile(filepath);

        Maze maze = new Maze(maze_str);
        maze.printMaze();

        MazeNavigator navigator = new MazeNavigator();
        return navigator.solveMaze(maze);
    }
}
