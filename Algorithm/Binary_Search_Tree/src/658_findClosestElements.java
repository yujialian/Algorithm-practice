class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k;
        int mid;
        while(l < r) {
            mid = l + (r - l) / 2;
            if(x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = l; i < (l + k); i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
