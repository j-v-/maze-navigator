import org.junit.Test;
import java.util.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jeavydsouza on 15/11/2017.
 */

public class MazeInputTest {

    @Test
    public void testReadInput(){
        String file_path = "./resources/mazes/input.txt";
        MazeInput mazeInput = new MazeInput();
        List<String> maze_str = mazeInput.readFile(file_path);
        assertEquals(false, maze_str.isEmpty());

        Maze maze = new Maze(maze_str);
        maze.printMaze();

        assertEquals(5, maze.getHeight());
        assertEquals(5, maze.getWidth());

        assertEquals(1, maze.getStartCol());
        assertEquals(1, maze.getStartRow());

        assertEquals(3, maze.getDestCol());
        assertEquals(3, maze.getDestRow());

    }
}
