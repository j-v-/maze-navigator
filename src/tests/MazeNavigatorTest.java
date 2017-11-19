import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by jeavydsouza on 15/11/2017.
 */
public class MazeNavigatorTest {

    @Test
    public void testNavigation(){
        MazeRunner amazer = new MazeRunner();
        String file_path = "./resources/mazes/input.txt";
        System.out.println("MAZE --> " + file_path);
        assertEquals(true, amazer.solveMaze(file_path));
        System.out.println("");

        file_path = "./resources/mazes/small.txt";
        System.out.println("MAZE --> " + file_path);
        assertEquals(true, amazer.solveMaze(file_path));
        System.out.println("");

        file_path = "./resources/mazes/sparse_medium.txt";
        System.out.println("MAZE --> " + file_path);
        assertEquals(true, amazer.solveMaze(file_path));
        System.out.println("");

        file_path = "./resources/mazes/medium_input.txt";
        System.out.println("MAZE --> " + file_path);
        assertEquals(true, amazer.solveMaze(file_path));

        //file_path = "./resources/mazes/large_input.txt";
        //assertEquals(true, amazer.solveMaze(file_path));
    }

    @Test
    public void testUnsolvableMaze(){
        MazeRunner amazer = new MazeRunner();
        String file_path = "./resources/mazes/unsolvable.txt";
        System.out.println("MAZE --> " + file_path);
        assertEquals(false, amazer.solveMaze(file_path));
        System.out.println("");

    }
}