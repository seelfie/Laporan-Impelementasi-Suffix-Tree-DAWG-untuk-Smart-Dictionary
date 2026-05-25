public class State {
    public int len;
    public int link;
    public int[] next;
    public boolean isClone;
    private static final int ALPHA = 26;

    public State(int len, int link) {
        this.len     = len;
        this.link    = link;
        this.isClone = false;
        this.next    = new int[ALPHA];
        for (int i = 0; i < ALPHA; i++) {
            this.next[i] = -1;
        }
    }

    public void copyTransitionsFrom(State src) {
        for (int i = 0; i < ALPHA; i++) {
            this.next[i] = src.next[i];
        }
    }

    public int get(char c) {
        return next[c - 'a'];
    }
 
    public void put(char c, int dst) {
        next[c - 'a'] = dst;
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;
        for (int i = 0; i < ALPHA; i++) {
            if (next[i] != -1) {
                if (!first) sb.append(", ");
                sb.append((char)('a' + i)).append("->").append(next[i]);
                first = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
