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

        int vowelIndex = 0;
        String firstLetter = input.substring(0, 1);

        if (input == null || input.length() == 0){
            return "";
        }

        if (isVowel(firstLetter)){
                result = input + "ay";
            }
        for (int i = 0; i < input.length(); i++){
            if (isVowel(input.substring(i, i + 1))){
                vowelIndex = i;
                break;
            }
        }

        String start = input.substring(0, vowelIndex);
        String rest = input.substring(vowelIndex);
        result = rest + start.toLowerCase() + "ay";

        if (Character.isUpperCase(input.charAt(0))){
            result = result.substring(0, 1).toUpperCase() + result.substring(1);
        }
        return result;
    }

    public static boolean isVowel(String letter){
        String vowels = "aeiouAEIOU";
        if (vowels.indexOf(letter) != -1) {
            return true;
        }
        return false;
    }
}
