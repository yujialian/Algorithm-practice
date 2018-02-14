
public class Selection_sort {
	private int[] sorting(int[] arr) {
		if(arr==null || arr.length == 0) {
			return new int[] {};
		}
		//int current = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			min = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
		return arr;
	}
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		Selection_sort selection = new Selection_sort();
		int[] arr = new int[] {4,7,2,1,8,0,9};
		for(int i = 0; i < arr.length; i++) {
		System.out.println(selection.sorting(arr)[i]);
	}
}
}
