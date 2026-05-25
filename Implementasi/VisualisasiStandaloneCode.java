import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n[1] Tree  [2] Automata  [3] Testing  [0] Keluar");
            System.out.print("Pilih: ");
            switch (sc.nextLine().trim()) {
                case "1" -> menuTree();
                case "2" -> menuDFA();
                case "3" -> testing();
                case "0" -> { System.out.println("Bye!"); return; }
            }
        }
    }

    static void menuTree() {
        Visualizer.TreeNode root = Visualizer.sampleTree();
        System.out.println("\n── Tree ──");
        Visualizer.printTree(root, "", true);
    }

    static void menuDFA() {
        System.out.println("\n[1] Berakhir 'ab'  [2] Jumlah 'a' genap");
        System.out.print("Pilih: ");
        Visualizer.DFA dfa = sc.nextLine().trim().equals("1")
            ? Visualizer.dfaEndsAB() : Visualizer.dfaEvenA();
        System.out.println();
        dfa.print();
        System.out.print("\nCoba string (atau Enter skip): ");
        String s = sc.nextLine().trim();
        if (!s.isEmpty())
            System.out.println("\"" + s + "\" → " + (dfa.run(s) ? "DITERIMA" : "DITOLAK"));
    }

    static void testing() {
        int ok = 0, total = 0;

        // Tree
        Visualizer.TreeNode r = Visualizer.sampleTree();
        ok += check("root = A",       r.val.equals("A"));              total++;
        ok += check("root 3 anak",    r.children.size() == 3);         total++;
        ok += check("B punya 2 anak", r.children.get(0).children.size() == 2); total++;

        // DFA 1
        Visualizer.DFA d1 = Visualizer.dfaEndsAB();
        ok += check("'ab' diterima",  d1.run("ab"));   total++;
        ok += check("'ba' ditolak",   !d1.run("ba"));  total++;
        ok += check("'aab' diterima", d1.run("aab"));  total++;
        ok += check("'' ditolak",     !d1.run(""));    total++;

        // DFA 2
        Visualizer.DFA d2 = Visualizer.dfaEvenA();
        ok += check("'' diterima",    d2.run(""));     total++;
        ok += check("'aa' diterima",  d2.run("aa"));   total++;
        ok += check("'a' ditolak",    !d2.run("a"));   total++;
        ok += check("'aab' diterima", d2.run("aab"));  total++;

        System.out.printf("\nHasil: %d/%d PASS%n", ok, total);
    }

    static int check(String label, boolean cond) {
        System.out.println("  [" + (cond ? "PASS" : "FAIL") + "] " + label);
        return cond ? 1 : 0;
    }
}
