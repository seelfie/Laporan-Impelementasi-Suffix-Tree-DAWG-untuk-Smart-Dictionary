public class SuffixTree {

    TreeNode root;

    public SuffixTree() {
        root = new TreeNode('\0');
    }

    public void insertSuffix(String suffix) {

        TreeNode current = root;

        for (int i = 0; i < suffix.length(); i++) {

            char ch = suffix.charAt(i);

            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new TreeNode(ch));
            }

            current = current.children.get(ch);
        }

        current.isEnd = true;
    }

    public void buildTree(String text) {

        for (int i = 0; i < text.length(); i++) {

            String suffix = text.substring(i);

            insertSuffix(suffix);
        }
    }

    public boolean search(String pattern) {

        TreeNode current = root;

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);

            if (!current.children.containsKey(ch)) {
                return false;
            }

            current = current.children.get(ch);
        }

        return true;
    }
}