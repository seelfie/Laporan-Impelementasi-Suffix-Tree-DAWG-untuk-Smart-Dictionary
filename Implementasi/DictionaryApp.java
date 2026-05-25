import java.util.Scanner;

public class DictionaryApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] words = {
            "teknologi", "informasi",
            "information", "technology",
            "cyber", "security",
            "internet", "of", "things",
            "integration", "system",
            "smart", "city"
        };

    while (true) {
        System.out.println("=== IT ITS DICTIONARY ===");
        System.out.println("1. Search Word");
        System.out.println("2. Autocomplete");
        System.out.println("3. Substring Search");
        System.out.println("4. Exit");
    
        System.out.print("Pilih menu: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 4) {
        System.out.println("Keluar dari program...");
        break;
        }

        System.out.print("Masukkan kata: ");
        String keyword = input.nextLine();

        System.out.println("Hasil:");

        boolean found = false;

        switch(choice) {

            case 1:
                for(String word : words) {
                    if(word.equals(keyword)) {
                        System.out.println(word);
                        found = true;
                    }
                }
                break;

            case 2:
                for(String word : words) {
                    if(word.startsWith(keyword)) {
                        System.out.println(word);
                        found = true;
                    }
                }
                break;

            case 3:
                for(String word : words) {
                    if(word.contains(keyword)) {
                        System.out.println(word);
                        found = true;
                    }
                }
                break; 
            
            default:
                System.out.println("Menu tidak valid");
        }

        if(!found && choice >= 1 && choice <= 3) {
            System.out.println("Kata tidak ditemukan");
        }

        input.close();
    }
    }
}
