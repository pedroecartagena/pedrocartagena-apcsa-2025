package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.

        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";

        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.
        int vowelIndex = 0;
        String firstLetter = input.substring(0, 1);
        int uppercaseIndex = 0;

        if (isVowel(firstLetter)){
                result = input + "ay";
            }
        for (int i = 0; i < input.length(); i++){
            String currentLetter = input.substring(i, i + 1);
            if (isVowel(input.substring(i, i + 1))){
                vowelIndex = i;
                break;
            }
        }
        result = input.substring(vowelIndex) + input.substring(0, vowelIndex) + "ay";
        if (Character.isUpperCase(input.charAt(0))){
            result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
        }
        
        return ;
    }

    public static boolean isVowel(String letter){
        String vowels = "aeiouAEIOU";
        if (vowels.indexOf(letter) != -1) {
            return true;
        }
        return false;
    }
}
