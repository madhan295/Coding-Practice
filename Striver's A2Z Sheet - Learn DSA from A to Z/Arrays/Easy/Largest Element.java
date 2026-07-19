// Given an array of integers nums, return the value of the largest element in the array

// Example 1
// Input: nums = [3, 3, 6, 1]
// Output: 6
// Explanation: The largest element in array is 6

// Example 2
// Input: nums = [3, 3, 0, 99, -40]
// Output: 99
// Explanation: The largest element in array is 99

package Striver's A2Z Sheet - Learn DSA from A to Z.Arrays.Easy;

class Solution {
    public int largestElement(int[] nums) {
        int max = 0;
        for (int i: nums) {
            if (i>max) max = i;
        }
        return max;
    }
}
