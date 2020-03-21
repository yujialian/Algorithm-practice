class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i += 2*k) {
            int index = i;
            int j = Math.min(index+k-1, arr.length - 1);
            while(index < j) {
                char tmp = arr[index];
                arr[index] = arr[j];
                arr[j] = tmp;
                index++;
                j--;
            }
        }
        return new String(arr);
    }
}
