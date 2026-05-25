import java.util.HashMap;

public class TreeNode {

    char character;
    HashMap<Character, TreeNode> children;
    boolean isEnd;

    public TreeNode(char character) {

        this.character = character;
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}