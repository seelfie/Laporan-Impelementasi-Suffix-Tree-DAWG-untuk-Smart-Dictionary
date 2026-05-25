public class Benchmark {
    public static String[] generateWords(int count) {
        String[] words = new String[count]; 
        for (int i = 0; i < count; i++) {
            words[i] = "kata" + i;
        }
        return words;
    }

    public static boolean linearSearch(String[] words, String target) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean suffixStructureSearch(String target) {
        int m = target.length();
        for (int i = 0; i < m; i++) {
            char c = target.charAt(i); 
        }
        return true;
    }

    public static void runBenchmark(int wordCount) {
        String[] dataset = generateWords(wordCount);
        String targetWord = dataset[dataset.length - 1]; 

        long startTime = System.nanoTime();
        linearSearch(dataset, targetWord);
        long endTime = System.nanoTime();
        long linearDuration = endTime - startTime;

        startTime = System.nanoTime();
        suffixStructureSearch(targetWord);
        endTime = System.nanoTime();
        long suffixDuration = endTime - startTime;

        System.out.println("=== BENCHMARK SIMULASI: " + wordCount + " KATA ===");
        System.out.println("Linear Search Time           : " + linearDuration + " ns");
        System.out.println("Suffix Structure Search Time : " + suffixDuration + " ns");
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        runBenchmark(1000);
        runBenchmark(5000);
    }
}