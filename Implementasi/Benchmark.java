public class Benchmark {

    public static String[] generateWords(int count) {
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = "kata" + i;
        }
        return words;
    }

    public static boolean linearSearch(String[] words, String target) {
        for (String w : words) {
            if (w.equals(target)) return true;
        }
        return false;
    }

    public static void runBenchmark(int wordCount, SuffixTree st, DAWG dawg) {

        String[] dataset = generateWords(wordCount);
        String target = dataset[dataset.length - 1];

        long start = System.nanoTime();
        linearSearch(dataset, target);
        long linearTime = System.nanoTime() - start;

        start = System.nanoTime();
        st.search(target);
        long suffixTime = System.nanoTime() - start;

        start = System.nanoTime();
        dawg.contains(target);
        long dawgTime = System.nanoTime() - start;

        System.out.println("=== BENCHMARK " + wordCount + " KATA ===");
        System.out.println("Linear Search : " + linearTime + " ns");
        System.out.println("Suffix Tree   : " + suffixTime + " ns");
        System.out.println("DAWG          : " + dawgTime + " ns");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {

        SuffixTree st = new SuffixTree();
        DAWG dawg = new DAWG();

        String[] data = generateWords(5000);

        for (String w : data) {
            st.buildTree(w);
        }

        dawg.reset();
        dawg.build(String.join("", data)); 

        runBenchmark(1000, st, dawg);
        runBenchmark(5000, st, dawg);
    }
}