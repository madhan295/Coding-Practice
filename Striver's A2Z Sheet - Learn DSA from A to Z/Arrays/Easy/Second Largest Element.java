package Striver's A2Z Sheet - Learn DSA from A to Z.Arrays.Easy;

public class Second Largest Element {
 class Solution {
    public static int secondLargestElement(int[] nums) {
        int lar = Integer.MIN_VALUE;
        int seclar = Integer.MIN_VALUE;
        for (int i : nums) {
            if(i > lar) {
                seclar = lar;
                lar = i;
            } else if (i < lar && i > seclar) {
                seclar = i;
            }
        }
        return lar == seclar ? -1 : seclar;
    }
}
}