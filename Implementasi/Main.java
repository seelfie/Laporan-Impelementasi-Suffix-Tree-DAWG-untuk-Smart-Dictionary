import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Data di dalam program
        String text = "teknologi informasi information technology cyber security internet of things integration system smart city";

        // Membuat suffix tree
        SuffixTree tree = new SuffixTree();

        // Build tree
        tree.buildTree(text);

        // Loop terus
        while (true) {

            System.out.print("\nMasukkan substring (ketik exit untuk keluar): ");
            String pattern = input.nextLine();

            // Keluar program
            if (pattern.equals("exit")) {
                System.out.println("Program selesai");
                break;
            }

            // Search substring
            boolean found = tree.search(pattern);

            if (found) {

                System.out.println("Substring ditemukan!");
                System.out.println("Ditemukan pada kata:");

                String[] words = text.split(" ");

                boolean ada = false;

                for (String word : words) {

                    if (word.contains(pattern)) {

                        System.out.println("- " + word);
                        ada = true;
                    }
                }

                // Kalau substring ada di tree tapi tidak muncul di kata
                if (!ada) {
                    System.out.println("(substring ada di text)");
                }

            } else {

                System.out.println("Substring tidak ditemukan.");
            }
        }

        input.close();
    }
}