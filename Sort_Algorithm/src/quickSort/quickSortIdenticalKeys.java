class quickSortIdenticalKeys {
  public static int[] quickSort(int[] array) {
		if (array == null || array.length == 0) return new int[0];
		__quickSort(array, 0, array.length - 1);
		return array;
  }
	private static void __quickSort(int[] array, int l, int r) {
		if (l >= r) return;
		int p = __partition(array, l, r);
		__quickSort(array, l, p - 1);
		__quickSort(array, p + 1, r);
	}
	private static int __partition(int[] array, int l, int r) {
		int p = array[l];
		int left = l + 1, right = r;
		while (true) {
			while (left <= r && array[left] < p) left++; 
			while (right >= l && array[right] > p) right--;
			if (left > right) break;
			swap(array, left, right);
			left++;
			right--;
		}
		swap(array, right, l);
		return right;
	}
	private static void swap(int[] array, int l, int r) {
		int tmp = array[l];
		array[l] = array[r];
		array[r] = tmp;
	}
}
