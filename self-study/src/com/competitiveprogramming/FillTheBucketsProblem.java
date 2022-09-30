import java.util.Scanner;

/**
 * FillTheBucketsProblem
 */
public class FillTheBucketsProblem {

    public static void main(String[] args) {
        // int count = fillBuckets(60, 1);
        int count = 0;
        Scanner s = new Scanner(System.in);
        String ip = s.nextLine();
        if (ip != null && !ip.trim().isEmpty()) {
            String[] parts = ip.split(" ");
            count = fillBuckets(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
        System.out.println(count);
    }

    public static int fillBuckets(int N, int K) {
        int count = 0;
        int doneWeight = 0;
        int n = N;
        int k = K;
        if(N == 0 || K == 0) return 0;
        int capacity = 0;
        for (int i = 1; i <= N; i++) {
            capacity += i;
        }
        if (K > capacity) return -1;
        do {
            if (k <= n) {
                count += 1;
                break;
            } else {
                doneWeight += n;
                n -= 1;
                count += 1;
            }
        } while (doneWeight < K);
        return count;
    }
}