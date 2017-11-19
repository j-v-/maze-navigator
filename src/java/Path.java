import java.util.LinkedList;

/**
 * @author jeavydsouza on 15/11/2017.
 */
public class Path {
    private LinkedList<Node> path;

    public Path(){
        this.path = new LinkedList<Node>();
    }

    public boolean isPrevious(Node node){
        Node last_node = path.getLast();
        if(last_node.getRow() == node.getRow() && last_node.getCol() == node.getCol())
            return true;
        return false;
    }

    public boolean isSource(Node node){
        Node source_node = path.getFirst();
        if(source_node.getRow() == node.getRow() && source_node.getCol() == node.getCol())
            return true;
        return false;
    }

    public void removePath(Node node){
        this.path.removeLast();
    }

    public void addPath(Node node){
        this.path.add(node);
    }

    public LinkedList<Node> getPath() {
        return path;
    }

    public void setPath(LinkedList<Node> path) {
        this.path = path;
    }

    public boolean isInPath(int row, int col) {
        for(Node n : path){
            if(n.getRow() == row && n.getCol() == col)
                return true;
        }
        return false;
    }

    /**
     * Removes any loops in the path so that only the path leading to destination is shown
     *
     * @return path
     */
    public LinkedList<Node> pathWithoutLoops(){
        int n = this.path.size();
        LinkedList<Node> the_path = new LinkedList<Node>();
        for(int i = 0; i < n ; i++){
            Node node = this.path.get(i);
            clearLoops(the_path, node);
        }
        return the_path;
    }

    private void clearLoops(LinkedList<Node> npath, Node node){
        int index = -1;
        for(int i = 0; i < npath.size() ; i++){
            if (npath.get(i).getCol() == node.getCol() && npath.get(i).getRow() == node.getRow())
                index = i;
        }
        if(index >= 0)
            npath.subList(index, npath.size()).clear();
        npath.add(node);
    }
}
