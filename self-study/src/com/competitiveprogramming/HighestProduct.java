import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * HighestProduct
 * 
 * Given an array of 'n' integers, find the highest product obtained by multiplying any 3 numbers in the array.
 * Repetition possible.
 * 
 * Ex. For arr = [-5, -2, 0, 1, 1, 5] , the highrst product obtained would be -5 * -2 * 5 = 50
 * 
 * Constraints: min array length = 3
 */
public class HighestProduct {

    public static void main(String[] args) {
        int prod = HighestProduct.calculateHighestProduct(new int[] {11, 2, 3, 4});
        // int prod = HighestProduct.calculateHighestProduct(new int[] {-5, -2, 0, 1, 1, 5});
        
        System.out.println(prod);
    }

    public static int calculateHighestProduct (int[] arr) {
        int product = 1;
        HashSet<Integer> setIntegers = new HashSet<Integer>();
        HashMap<String, Integer> mapProd = new HashMap<String, Integer>();
        if (arr.length == 3) {
            return arr[0] * arr[1] * arr[2];
        }
        else if (arr.length > 3) {
            for (int elem : arr) {
                setIntegers.add(elem);
            }

            List<Integer> lst = new ArrayList<Integer>(setIntegers);
            Collections.sort(lst);

            int[] intArr = lst.stream().mapToInt(i -> i.intValue()).toArray();
            
            for(int i=1;i<=intArr.length-2;i++) {
                for(int j=i+1;j<intArr.length;j++) {
                    // System.out.println(i);
                    // System.out.println(j);
                    mapProd.put(
                        String.valueOf(intArr[i]) + "_" + String.valueOf(intArr[j]), 
                        intArr[i] * intArr[j]
                    );
                }
            }

            // mapProd.forEach((k, v) -> System.out.println(k + " --> " + v.intValue()));
            
            int num1;
            int num2;
            int num3;
            for (int i = 0; i < intArr.length-2; i++) {
                for (String s : mapProd.keySet()) {
                    String[] twoNums = s.split("_");
                    int n1 = Integer.parseInt(twoNums[0]);
                    int n2 = Integer.parseInt(twoNums[1]);
                    int thisProd =  n1 * n2 * intArr[i];
                    if(thisProd > product) {
                        num1 = intArr[i];
                        num2 = n1;
                        num3 = n2;
                        product = thisProd;
                    }
                }
            }

        }
        return product;
    }
}