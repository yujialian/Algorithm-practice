
public class BinarySearchIterative {
	public int search(int[] arr, int target) {
		if(arr == null) return -1;
		int l = 0, r = arr.length - 1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(arr[mid] == target) {
				return mid;
			} else if(arr[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		BinarySearchIterative test = new BinarySearchIterative();
		int[] arr = new int[] {1,4,6,8,12,56,78,99};
		System.out.println(test.search(arr, 8));
		System.out.println(test.search(arr, 55));
	}
}
