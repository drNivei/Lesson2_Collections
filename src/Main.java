import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer n;
        Words words = new Words();
        Scanner new_word = new Scanner(System.in);
        System.out.println("Введите количество слов");
        n = Integer.valueOf(new_word.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("\nВведите следующее слово");
            words.addWord(new_word.nextLine());
        }
        System.out.println("Самое частое слово - " + words.find_Most_Common_Word());
    }

}