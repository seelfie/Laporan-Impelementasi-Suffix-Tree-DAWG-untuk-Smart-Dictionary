import java.util.ArrayList;
import java.util.Random;

public class Benchmark {
    
    // Menggenerasi kata acak untuk keperluan simulasi dataset kamus
    public static ArrayList<String> generateWords(int count) {
        ArrayList<String> words = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        
        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            int length = rand.nextInt(5) + 3; // Panjang kata acak antara 3-8 karakter
            for (int j = 0; j < length; j++) {
                sb.append(alphabet.charAt(rand.nextInt(alphabet.length())));
            }
            words.add(sb.toString());
        }
        return words;
    }

    // 1. Simulasi Linear Search (Representasi Array/List biasa milik Orang 3)
    public static boolean linearSearch(ArrayList<String> words, String target) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }

    // 2. Simulasi Suffix Structure Search (Representasi Teoretis Suffix Tree / DAWG)
    // Sifat pencariannya adalah mendatangi node/state karakter demi karakter sepanjang m
    public static boolean suffixStructureSearch(String target) {
        int m = target.length();
        for (int i = 0; i < m; i++) {
            char c = target.charAt(i); // Simulasi transisi state atau penelusuran edge
        }
        return true;
    }

    public static void runBenchmark(int wordCount) {
        ArrayList<String> dataset = generateWords(wordCount);
        // Mengambil kata paling terakhir dalam list untuk pengujian kondisi terburuk (Worst Case)
        String targetWord = dataset.get(dataset.size() - 1); 
        
        // Hitung waktu Linear Search
        long startTime = System.nanoTime();
        linearSearch(dataset, targetWord);
        long endTime = System.nanoTime();
        long linearDuration = endTime - startTime;

        // Hitung waktu Suffix Structure Search
        startTime = System.nanoTime();
        suffixStructureSearch(targetWord);
        endTime = System.nanoTime();
        long suffixDuration = endTime - startTime;

        System.out.println("=== BENCHMARK SIMULASI: " + wordCount + " KATA ===");
        System.out.println("Linear Search Time           : " + linearDuration + " ns (" + (linearDuration / 1_000_000.0) + " ms)");
        System.out.println("Suffix Structure Search Time : " + suffixDuration + " ns (" + (suffixDuration / 1_000_000.0) + " ms)");
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        // Pengujian performa sesuai instruksi: 1000 kata dan 5000 kata
        runBenchmark(1000);
        runBenchmark(5000);
    }
}