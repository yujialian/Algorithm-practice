import java.util.*;
public class Merge_sort {
	private void merge(int[] arr, int l, int mid, int r) {
		/*
		Initialize, i point to left starting position, j point to right
		start point mid + 1
		*/
		int[] aux = new int[r-l+1];
		for(int i = l; i <= r; i++) {
			aux[i-l] = arr[i];
		}
		int lt = l;
		int rt = mid + 1;
		for(int k = l; k <= r; k++) {
			if(lt > mid) {
				arr[k] = aux[rt-l];
				rt++;
			} else if(rt > r) {
				arr[k] = aux[lt-l];
				lt++;
			} else if(aux[lt-l] < aux[rt-l]) {
				arr[k] = aux[lt-l];
				lt++;
			} else {
				arr[k] = aux[rt-l];
				rt++;
			}
		}
	}
	private void sort(int[] arr, int l, int r) {
		if(l >= r) {
			return;
		}
		int mid = l + (r-l)/2;
		sort(arr, l, mid);
		sort(arr, mid+1, r);
		merge(arr, l, mid, r);
	}
	public static void main(String[] args) {
		Merge_sort srt = new Merge_sort();
		int[] arr = new int[] {1,2,6,3,1,7,2,8};
		srt.sort(arr, 0, arr.length-1);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
