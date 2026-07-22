class Main {
    public static int removeDuplicates(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i: nums) s.add(i);
        return s.size();
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 34,3, 5};
        System.out.println(removeDuplicates(ar));
    }
}