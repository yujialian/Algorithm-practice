public class BinarySearch {
	public int search(int[] arr, int l, int r, int target) {
		if(arr == null || l > r) return -1;
		int mid = l + (r - l) / 2;
		if(arr[mid] == target) {
			return mid;
		} else if(arr[mid] > target){
			/*Search from l to mid - 1*/
			return search(arr,l, mid - 1, target);
		} else {
			/*Search from mid + 1 to r*/
			return search(arr,mid+1, r, target);
		}
	}
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] arr = new int[]{1,4,6,8,9,17,28,95};
		System.out.println(bs.search(arr,0,arr.length - 1, 1));
		System.out.println(bs.search(arr, 0, arr.length - 1, 100));
	}
}
