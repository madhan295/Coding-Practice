package Striver's A2Z Sheet - Learn DSA from A to Z.Arrays.Easy;

class Main {
    public static boolean isSorted(ArrayList<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1) <= nums.get(i)) continue;
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(1, 2, 3, 34, 5));
        System.out.println(isSorted(ar));
    }
}
