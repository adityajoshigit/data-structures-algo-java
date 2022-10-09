import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Stream;


/**
 * RearrangeString 
 * 
 * Given a string of random length and random contents of characters, that do not include
 * special characters, write an algorithm, using pseudo code that will rearrange the string
 * with all its consonants followed by all its repeating characters followed by all its vowels.
 * For instance, given “assignment1” the algorithm must return: “gmtsn1aie”.
 *
 */
public class RearrangeString {

    public static void main(String[] args) {
        
        // String inputString = "assignment1";
        // StringBuilder b = new StringBuilder("");
        // int len = inputString.length();
        // // new ArrayList<String>(Arrays.asList(inputString.split("")))
        // List<String> lstVowels = new ArrayList<String>();
        // List<String> lstRepConsonants = new ArrayList<String>();
        // List<String> lstNonLetters = new ArrayList<String>();
        // for(int i=0;i<len;i++) {
        //     char thisChar = inputString.charAt(i);
        //     String thisCharStr = String.valueOf(thisChar);
        //     if (thisCharStr.matches("[a-z]")) {
        //         if(
        //             'a' == thisChar || 'e' == thisChar || 'i' == thisChar || 'o' == thisChar || 'u' == thisChar 
        //         ) {
        //         } else {
        //             if((inputString.substring(i+1, len)).contains(thisChar+"")) {
        //                 lstRepConsonants.add(thisCharStr);
        //             } else if(!lstRepConsonants.contains(thisCharStr)) {
        //                 b.append(thisCharStr);
        //             }
        //         }
        //     } else {
        //         lstNonLetters.add(thisCharStr);
        //     }

        // }

        // lstVowels.forEach(e -> System.out.print(e + "  "));

        // b.append(String.join("", new HashSet<String>(lstRepConsonants)));
        // b.append(String.join("", new HashSet<String>(lstNonLetters)));
        // b.append(String.join("", new HashSet<String>(lstVowels)));
        // System.out.println(b.toString());


        System.out.println(
            reaarrangeString("assignment1")
        );
    }

    public static String reaarrangeString(String inputString) {
        StringBuilder b = new StringBuilder();

        char[] vowels = new char[inputString.length()];
        char[] repeatingConsonants = new char[inputString.length()];
        char[] nonLetters = new char[inputString.length()];

        int nextVowelIndex = 0;
        int nextRepConsonantIndex = 0;
        int nextNonLetterIndex = 0;
        String tempStr = "";

        for (int i = 0; i < inputString.length(); i++) {
            char thisChar = inputString.charAt(i);
            // condition 1 : vowel
            if (
                'a' == thisChar || 'e' == thisChar || 'i' == thisChar || 'o' == thisChar || 'u' == thisChar 
            ) {
                vowels[nextVowelIndex++] = thisChar;
            } 
            // condition 2 : consonant
            else if((String.valueOf(thisChar)).matches("[a-z]")) {
                if(
                    (inputString.substring(i+1, inputString.length())).contains(String.valueOf(thisChar))
                || (inputString.substring(0, i)).contains(String.valueOf(thisChar))
                ) {
                    repeatingConsonants[nextRepConsonantIndex++] = thisChar;
                } else {
                    b.append(String.valueOf(thisChar));
                }
            } 
            // condition 3 : non letter chars - numbers
            else {
                nonLetters[nextNonLetterIndex++] = thisChar;
            }
        }

        for (int i = 0; i < repeatingConsonants.length; i++) {
            if (repeatingConsonants[i] == '\u0000') break;
            else {
                if(!b.toString().contains(String.valueOf(repeatingConsonants[i]))) 
                    b.append(repeatingConsonants[i]);
            }
        }

        for (int i = 0; i < nonLetters.length; i++) {
            if (nonLetters[i] == '\u0000') break;
            else {
                if(!b.toString().contains(String.valueOf(nonLetters[i]))) 
                    b.append(nonLetters[i]);
            }
        }

        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == '\u0000') break;
            else {
                if(!b.toString().contains(String.valueOf(vowels[i]))) 
                    b.append(vowels[i]);
            }
        }

        return b.toString();
    }

}