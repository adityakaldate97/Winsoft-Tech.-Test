public class CharacterDuplicates {
    public static void main(String[] args) {
        String inputString = "Great responsibility";
        int characterCount;

       
        char[] characters = inputString.toCharArray();

        System.out.println("Duplicate characters in the given string: ");
        for (int i = 0; i < characters.length; i++) {
            characterCount = 1;
            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j] && characters[i] != ' ') {
                    characterCount++;
                    characters[j] = '0';
                }
            }
            if (characterCount > 1 && characters[i] != '0')
                System.out.println(characters[i]);
        }
    }
}
