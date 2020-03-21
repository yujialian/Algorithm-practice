class test {
    public int maxSubArray(int[] nums) {
        int curr = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            curr = Math.max(curr + nums[i], nums[i]);
            max = Math.max(curr, max);
            System.out.println("curr: "+curr + " max: "+ max);
        }
        return max;
    }
    public static void main(String[] args) {
      test sb = new test();
      int[] arr = new int[] {1,2,3,-1,2};
      System.out.println(sb.maxSubArray(arr));
    }
}
