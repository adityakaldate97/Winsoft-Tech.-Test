import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string:");
        String input = scanner.nextLine();

        Map<String, Integer> wordCounts = countWords(input);

        System.out.println("Word occurrences:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        String[] words = input.split("\\s+");

        for (String word : words) {
            String formattedWord = word.toLowerCase();
            int count = wordCountMap.getOrDefault(formattedWord, 0);
            wordCountMap.put(formattedWord, count + 1);
        }

        return wordCountMap;
    }
}
