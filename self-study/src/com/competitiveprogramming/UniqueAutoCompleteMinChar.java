import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * pod2_1
 */
public class UniqueAutoCompleteMinChar {

    public static void main(String[] args) {
        UniqueAutoCompleteMinChar p = new UniqueAutoCompleteMinChar();
        // p.findSearchLength(
        //     "hello,heat,hi".split(",")
        // );

        // p.findSearchLength(
        //     "hi".split(",")
        // );

        // p.findSearchLength(
        //     "ab,abc".split(",")
        // );

        // p.findSearchLength(
        //     "this,is,the,sample,input".split(",")
        // );

        // p.findSearchLength(
        //     "mammoth,troubled,morning,discuss,river,confess,sea,drum,discussion".split(",")
        // );


        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        if (input != null && input.trim().length() > 1) {
            int c = p.findSearchLength(
                input.split(",")
            );
            System.out.print(c);
        } else {
            System.out.print(0);
        }
    }


    public int findSearchLength(String[] words) {

        List<String> existingWords = Arrays.asList(words);
        int totalCount = 0;
        for (String word : words) {
            boolean isSingleMatch = false;
            int count = 0;
            // System.out.println("word = " + word);
            // System.out.println("count = " + count);
            // System.out.println("isSingleMatch = " + isSingleMatch);
            for (int i = 1; i <= word.length(); i++) {
                String subword = word.substring(0, i);
                List<String> lstMatchingWords = new ArrayList<String>();
                // do {
                    // System.out.println("subword ===> " + subword);
                    lstMatchingWords.clear();
                    lstMatchingWords 
                        = existingWords
                            .stream()
                            .filter(s -> s.startsWith(subword))
                            .collect(Collectors.toList());
                    count = i;
                    // System.out.println("count ----> = " + count);
                    isSingleMatch = lstMatchingWords.size() == 1 ? true : false;
                    // System.out.println("isSingleMatch ----> = " + isSingleMatch);
                // } while (
                //     isSingleMatch
                // );
                // System.out.println("isSingleMatch @ End of Inner for loop:  " + isSingleMatch);
                if(isSingleMatch || i == word.length()) break;
            }
            totalCount += count;
            // System.out.println("totalCount here = ");
        }
        // System.out.println("totalCount = " + totalCount);
        return totalCount;

    }
}