class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return new int[]{1};
        }
        int plus = 1;
        for(int i = digits.length-1; i >= 0&&plus > 0; i--) {
            plus += digits[i];
            digits[i] = plus % 10;
            plus = plus / 10;
        }
        if(plus != 0) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            digits = arr;
        }
        return digits;
    }
}