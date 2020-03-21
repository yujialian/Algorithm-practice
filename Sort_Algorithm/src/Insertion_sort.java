
public class Insertion_sort {
	private int[] insertion(int[] arr) {
		if(arr == null || arr.length == 0) {
			return new int[] {};
		}
		for(int i = 1; i < arr.length; i++) {
			for(int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {5,7,3,2,6,8,10};
		Insertion_sort ins = new Insertion_sort();
		for(int i = 0; i < arr.length; i++) {
			System.out.println(ins.insertion(arr)[i]);
		}
	}
}
