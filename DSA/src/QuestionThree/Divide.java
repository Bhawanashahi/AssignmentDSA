package QuestionThree;//Question Three(a)
//Ans

public class Divide {
    public static int minProductDifference(int[] arr) {
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;

        // Iterate over all possible ways of dividing the array into two subarrays
        for (int mask = 0; mask < (1 << n); mask++) {
            int prod1 = 1, prod2 = 1;
            int cnt1 = 0, cnt2 = 0;

            // Compute the product and count of elements in each subarray
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    prod1 *= arr[i];
                    cnt1++;
                } else {
                    prod2 *= arr[i];
                    cnt2++;
                }
            }

            // Compute the absolute difference of the products
            int diff = Math.abs(prod1 - prod2);

            // Update the minimum absolute difference found so far
            if (cnt1 == cnt2 && diff < minDiff) {
                minDiff = diff;
            }
        }


        return minDiff;
    }
}
