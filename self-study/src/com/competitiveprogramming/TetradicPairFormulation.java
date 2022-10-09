public class TetradicPairFormulation {
    public static void main(String[] args) {
        findTetradicPair(new int[] { 11, 111, 88, 101, 181,808, 1, 818, 0 });
    }

    public static void findTetradicPair(int[] intArr) {
        int largestDiff = 0;
        int[] consecutivePair = new int[2];
        int[] farthestPair = new int[2];
        boolean farthestPairFound = false;
        for (int i = 0; i < intArr.length; i++) {
            for (int j = intArr.length - 1; j > i; j--) {
                if (!farthestPairFound && ( Math.abs(intArr[i] - intArr[j]) == 10 )) {
                    farthestPairFound = true;
                    farthestPair[0] = intArr[i];
                    farthestPair[1] = intArr[j];
                }
            }
            if ((i != intArr.length - 1) && ( Math.abs(intArr[i] - intArr[i+1]) > largestDiff )) {
                consecutivePair[0] = intArr[i];
                consecutivePair[1] = intArr[i+1];
            }
        }

        System.out.println("farthestPair[0] = " + farthestPair[0]);
        System.out.println("farthestPair[1] = " + farthestPair[1]);
        System.out.println("consecutivePair[0] = " + consecutivePair[0]);
        System.out.println("consecutivePair[1] = " + consecutivePair[1]);
    }
}
