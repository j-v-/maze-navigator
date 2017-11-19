import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Reads in maze file. Expects format to be correct.
 * @author jeavydsouza on 15/11/2017.
 */
public class MazeInput {

    public List<String> readFile(String location){
        List<String> sb = new ArrayList<String>();
        try {
            File file = new File(location);
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = bf.readLine()) != null){
                sb.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb;
    }
}
