import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
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
        
        String inputString = "assignment1";
        StringBuilder b = new StringBuilder("");
        int len = inputString.length();
        // new ArrayList<String>(Arrays.asList(inputString.split("")))
        Set<String> setVowels = new HashSet<String>();
        Set<String> setRepConsonants = new HashSet<String>();
        for(int i=0;i<len;i++) {
            char thisChar = inputString.charAt(i);
            System.out.println(thisChar);
            if(
                'a' == thisChar || 'e' == thisChar || 'i' == thisChar || 'o' == thisChar || 'u' == thisChar 
            ) {
                setVowels.add(String.valueOf(thisChar));
            } else {
                if((inputString.substring(i+1, len)).contains(thisChar+"")) {
                    setRepConsonants.add(String.valueOf(thisChar));
                } else if(!setRepConsonants.contains(String.valueOf(thisChar))) {
                    b.append(String.valueOf(thisChar));
                }
            }
        }
        b.append(String.join("", setRepConsonants));
        b.append(String.join("", setVowels));
        System.out.println(b.toString());


    }

}