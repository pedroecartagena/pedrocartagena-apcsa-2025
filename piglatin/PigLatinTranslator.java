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


        for(String word : input.split(" ")) {
             result += " " + translateWord(word);
        }

        return result.trim();
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";

        if (input == null || input.trim().length() == 0){
            return "";
        }

        int vowelIndex = 0;
        int puncIndex = 0;
        boolean hasPunc = false;
        String firstLetter = input.substring(0, 1);

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

        for (int j = 0; j < input.length(); j++){
            if (".?!".indexOf(input.substring(j)) != -1){
                hasPunc = true;
                puncIndex = j;
            }
        }

        if (hasPunc){
            result = result.substring(0, puncIndex - 2) + result.substring(puncIndex - 1, puncIndex + 1) + result.substring(puncIndex + 1) + ".";
        }
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

    public static boolean isPunc(String letter){
        String punc = ".!?";
        if (punc.indexOf(letter) != -1){
            return true;
        }
        return false;
    }
}
