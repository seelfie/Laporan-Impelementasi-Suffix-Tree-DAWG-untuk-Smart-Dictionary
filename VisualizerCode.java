import java.util.*;

public class Visualizer {

    static class TreeNode {
        String val;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(String v) { val = v; }
    }

    static void printTree(TreeNode n, String pre, boolean last) {
        System.out.println(pre + (last ? "└── " : "├── ") + n.val);
        String next = pre + (last ? "    " : "│   ");
        for (int i = 0; i < n.children.size(); i++)
            printTree(n.children.get(i), next, i == n.children.size() - 1);
    }

    static class DFA {
        String name, start;
        Set<String> accepts = new LinkedHashSet<>();
        Map<String, Map<Character, String>> delta = new LinkedHashMap<>();

        void add(String from, char sym, String to) {
            delta.computeIfAbsent(from, k -> new LinkedHashMap<>()).put(sym, to);
        }

        boolean run(String input) {
            String cur = start;
            for (char c : input.toCharArray()) {
                Map<Character, String> t = delta.get(cur);
                if (t == null || !t.containsKey(c)) return false;
                cur = t.get(c);
            }
            return accepts.contains(cur);
        }

        void print() {
            System.out.println("DFA: " + name);
            System.out.println("Start: " + start + "  Accept: " + accepts);
            for (String s : delta.keySet())
                for (var e : delta.get(s).entrySet())
                    System.out.printf("  %s%s -[%c]-> %s%n",
                        s.equals(start) ? "→" : " ",
                        accepts.contains(s) ? "(" + s + ")" : "[" + s + "]",
                        e.getKey(), e.getValue());
        }
    }

    static TreeNode sampleTree() {
        TreeNode r = new TreeNode("A");
        TreeNode b = new TreeNode("B"); b.children.add(new TreeNode("D")); b.children.add(new TreeNode("E"));
        TreeNode c = new TreeNode("C"); c.children.add(new TreeNode("F"));
        r.children.add(b); r.children.add(c); r.children.add(new TreeNode("G"));
        return r;
    }

    static DFA dfaEndsAB() {
        DFA d = new DFA(); d.name = "berakhir 'ab'"; d.start = "q0"; d.accepts.add("q2");
        d.add("q0",'a',"q1"); d.add("q0",'b',"q0");
        d.add("q1",'a',"q1"); d.add("q1",'b',"q2");
        d.add("q2",'a',"q1"); d.add("q2",'b',"q0");
        return d;
    }

    static DFA dfaEvenA() {
        DFA d = new DFA(); d.name = "jumlah 'a' genap"; d.start = "even"; d.accepts.add("even");
        d.add("even",'a',"odd"); d.add("even",'b',"even");
        d.add("odd",'a',"even"); d.add("odd",'b',"odd");
        return d;
    }
}
