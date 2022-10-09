
/**
 * 
 * Given an array of integers of any size, n≥1, and a number m, develop an algorithm as
 * a pseudo code (not a program!) that would swap all numbers with value m with the
 * subsequent numbers. You must perform this operation in place i.e., without creating an
 * additional array and keeping number of operations as small as possible. For example,
 * given an array [5, 4, 6, 9, 6, 3, 6], and a number 6, the algorithm will return [5, 4, 9, 6,
 * 3, 6, 6]. Finally, your algorithm must not use any auxiliary/additional storage to
 * perform what is needed.
 * 
 */
public class CustomSwap {
    public static void main(String[] args) {
        int[] res = performCustomSwapping(new int[] {5, 4, 6, 9, 6, 3, 6}, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.print(" " + res[i]);
        }
    }

    public static int[] performCustomSwapping(int[] intArr, int element) {
        
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] == element && i < intArr.length-1) {
                intArr[i] = intArr[i] + intArr[i+1];
                intArr[i+1] = intArr[i] - intArr[i+1];
                intArr[i] = intArr[i] - intArr[i+1];
            }
        }

        return intArr;
    }
}
