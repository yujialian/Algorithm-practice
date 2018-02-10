import java.util.*;
public class Merge_sort {
	private void merge(int[] arr, int l, int mid, int r) {
		int[] aux = Arrays.copyOfRange(arr, l, r+1);
		/*
		Initialize, i point to left starting position, j point to right
		start point mid + 1
		*/
		int i = l, j = mid + 1;
		for(int k = l; k <= r; k++) {
			if(i > mid) {//if the left part is finished
				arr[k] = aux[j-l];
				j++;
			} else if(j > r) {//if right part is finished
				arr[k] = aux[i-l];
				i++;
			} else if(aux[i-l] < aux[j-l]) {
				/*if left part is smaller than right part*/
				arr[k] = aux[i-l];
				i++;
			} else {
				arr[k] = aux[j-l];
				j++;
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
