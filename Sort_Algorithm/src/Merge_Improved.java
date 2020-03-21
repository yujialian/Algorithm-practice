
public class Merge_Improved {
	private void sort(int[] arr, int l, int mid, int r) {
		int[] aux = new int[r-l+1];
		for(int i = l; i <= r; i++) {
			aux[i-l] = arr[i];
		}
		int f = l;
		int s = mid + 1;
		for(int i = l; i <= r; i++) {
			if(f > mid) {
				arr[i] = aux[s-l];
				s++;
			} else if(s > r) {
				arr[i] = aux[f-l];
				f++;
			} else if(aux[f-l] > aux[s-l]) {
				arr[i] = aux[s-l];
				s++;
			} else {
				arr[i] = aux[f-l];
				f++;
			}
		}
	}
	private void merge(int[] arr, int l, int r) {
		/*We can do a comparison, and use insertion sort here.*/
		if(l >= r) {
			return;
		}
		int mid = l + (r - l) / 2;
		merge(arr, l, mid);
		merge(arr, mid+1, r);
		if(arr[mid] > arr[mid+1]) {
			sort(arr, l, mid, r);
		}
	}
	public static void main(String[] args) {
		Merge_Improved test = new Merge_Improved();
		int[] arr = new int[] {1,2,6,3,1,7,2,8};
		test.merge(arr, 0, arr.length-1);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
