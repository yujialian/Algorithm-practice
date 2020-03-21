/*For a nearly ordered／sorted array, insertion sort is much better than selection sort,
 * even better than o(nlogn) algorithm like merge sort/quick sort.When it's orded array,
 * insertion sort become o(n).
 * Improved version: Don't need swap element, insertion sort can end inner loop earlier.*/
public class Insertion_sort_improved {
	private int[] ins_imp(int[] arr) {
		if(arr == null || arr.length == 0) {
			return new int[] {};
		}
		int current = 0;
		int j;
		for(int i = 1; i < arr.length; i++) {
			current = arr[i];
			for(j = i; j > 0&&current < arr[j-1]; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = current;
		}
		return arr;
	}
	public static void main(String[] args) {
		Insertion_sort_improved test = new Insertion_sort_improved();
		int[] arr = new int[] {5,7,3,2,6,8,10};
		for(int i = 0; i < arr.length; i++) {
			System.out.print(test.ins_imp(arr)[i]+" ");
		}
	}
}
