import java.util.Scanner;
 
public class DAWG {
    private State[] pool;
    private int size;
    private int last;
    private static final int INIT_CAPACITY = 16;
 
    public DAWG() {
        pool = new State[INIT_CAPACITY];
        size = 0;
        last = newState(0, -1);
    }
 
    public void reset() {
        pool = new State[INIT_CAPACITY];
        size = 0;
        last = newState(0, -1);
    }
 
    private int newState(int len, int link) {
        if (size == pool.length) {
            State[] grown = new State[pool.length * 2];
            for (int i = 0; i < pool.length; i++) grown[i] = pool[i];
            pool = grown;
        }
        pool[size] = new State(len, link);
        return size++;
    }
 
    public void build(String s) {
        for (int i = 0; i < s.length(); i++) {
            extend(s.charAt(i));
        }
    }
 
    private void extend(char c) {
        int cur = newState(pool[last].len + 1, -1);
 
        int p = last;
        while (p != -1 && pool[p].get(c) == -1) {
            pool[p].put(c, cur);
            p = pool[p].link;
        }
 
        if (p == -1) {
            pool[cur].link = 0;
        } else {
            int q = pool[p].get(c);
            if (pool[q].len == pool[p].len + 1) {
                pool[cur].link = q;
            } else {
                int clone = newState(pool[p].len + 1, pool[q].link);
                pool[clone].copyTransitionsFrom(pool[q]);
                pool[clone].isClone = true;
 
                while (p != -1 && pool[p].get(c) == q) {
                    pool[p].put(c, clone);
                    p = pool[p].link;
                }
                pool[q].link   = clone;
                pool[cur].link = clone;
            }
        }
        last = cur;
    }
 
    public boolean contains(String pattern) {
        int cur = 0;
        for (int i = 0; i < pattern.length(); i++) {
            int nxt = pool[cur].get(pattern.charAt(i));
            if (nxt == -1) return false;
            cur = nxt;
        }
        return true;
    }
 
    public void printStates() {
        println("----------------------------------------------------------");
        println("               DAWG  -  State Diagram                    ");
        println("----------------------------------------------------------");
        printfLn("  %-7s %-5s %-9s %-8s %s",
                 "State", "Len", "SufLink", "Clone?", "Transitions");
        println("  ----------------------------------------------------------");
        for (int i = 0; i < size; i++) {
            State s = pool[i];
            String label = (i == 0) ? "[INIT] " : padLeft("[" + i + "]", 7);
            printfLn("%s %-5d %-9s %-8s %s",
                     label,
                     s.len,
                     s.link == -1 ? "-" : "" + s.link,
                     s.isClone ? "ya" : "tidak",
                     s.toString());
        }
        println("  ----------------------------------------------------------");
        printfLn("  Total state      : %d  (batas teoritis <= %d)",
                 size, 2 * pool[last].len - 1);
        printfLn("  Total transisi   : %d  (batas teoritis <= %d)",
                 countTransitions(), 3 * pool[last].len - 4);
    }
 
    public void traceSearch(String pattern) {
        printfLn("  Trace \"%s\" :", pattern);
        int cur = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            int nxt = pool[cur].get(c);
            if (nxt == -1) {
                printfLn("    State %-3d --'%c'--> [TIDAK ADA TRANSISI]", cur, c);
                println("  => Not Found");
                return;
            }
            printfLn("    State %-3d --'%c'--> State %d", cur, c, nxt);
            cur = nxt;
        }
        println("  => Found");
    }
 
    private int countTransitions() {
        int total = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < 128; j++)
                if (pool[i].next[j] != -1) total++;
        return total;
    }
 
    private static void println(String s) {System.out.println(s);}
    private static void printfLn(String fmt, Object... args) {System.out.printf(fmt + "%n", args);}
 
    private static String padLeft(String s, int width) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < width; i++) sb.append(' ');
        sb.append(s);
        return sb.toString();
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DAWG dawg = new DAWG();
 
        System.out.println("           DAWG (Directed Acyclic Word Graph)             ");
 
        while (true) {
            System.out.print("\nMasukkan string (atau ketik 'exit' untuk keluar): ");
            if (!sc.hasNextLine()) break;
            String input = sc.nextLine();
            if (input == null || input.equals("exit")) {
                println("Keluar dari program.");
                break;
            }
            input = input.trim().toLowerCase();
            if (input.isEmpty()) {
                println("String tidak boleh kosong.");
                continue;
            }
 
            dawg.reset();
            dawg.build(input);
            printfLn("%nDAWG dibangun untuk: \"%s\"%n", input);
 
            while (true) {
                System.out.print("\nCari substring ('ganti' untuk string baru atau 'showstates' untuk menunjukkan states): ");
                if (!sc.hasNextLine()) break;
                String pattern = sc.nextLine();
                
                if (pattern.equals("showstates")) {
                    dawg.printStates();
                    continue;
                }
                if (pattern == null || pattern.equals("ganti")) break;
                pattern = pattern.trim().toLowerCase();
                if (pattern.isEmpty()) {
                    println("Pattern tidak boleh kosong.");
                    continue;
                }
 
                println("");
                dawg.traceSearch(pattern);
                printfLn("%nOutput: %s", dawg.contains(pattern) ? "Found" : "Not Found");
            }
        }
    }
}