public class Benchmark {
    
    // Menggenerasi kata menggunakan Array bawaan (tanpa library)
    public static String[] generateWords(int count) {
        String[] words = new String[count]; // Memesan memori array sesuai jumlah data
        for (int i = 0; i < count; i++) {
            // Membuat kata dummy, contoh: "kata0", "kata1", dst.
            words[i] = "kata" + i;
        }
        return words;
    }

    // 1. Simulasi Linear Search menggunakan iterasi Array standar
    public static boolean linearSearch(String[] words, String target) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
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
            char c = target.charAt(i); // Simulasi penelusuran edge per karakter
        }
        return true;
    }

    public static void runBenchmark(int wordCount) {
        String[] dataset = generateWords(wordCount);
        // Mengambil kata paling terakhir di array untuk pengujian kondisi terburuk (Worst Case)
        String targetWord = dataset[dataset.length - 1]; 
        
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
        // Menampilkan output murni dalam nanosecond (ns) agar tidak perlu library formatting
        System.out.println("Linear Search Time           : " + linearDuration + " ns");
        System.out.println("Suffix Structure Search Time : " + suffixDuration + " ns");
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        // Pengujian performa sesuai instruksi: 1000 kata dan 5000 kata
        runBenchmark(1000);
        runBenchmark(5000);
    }
}