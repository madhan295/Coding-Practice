class Solution {
    public void rotateArrayByOne(int[] nums) {
        int n = nums.length;
        int temp = nums[0];
        for (int i = 1; i < n - 1; i++){
            nums[i-1] = nums[i];
        }
        nums[n] = temp;
    }
}