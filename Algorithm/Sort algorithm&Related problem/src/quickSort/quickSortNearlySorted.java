//For traditional quick sort, the sub array maybe different in terms of size, we can not guarantee that
//the height of the tree is log(n), it is highly possible that the depth of the tree is deeper than log(n),
//Worse case: deteriorate to o(n^2)
public class quickSortNearlySorted {
  public int partition(int[] arr, int l, int r) {
    swap(arr, l, (int)(Math.random()%(r-l+1)) + l);
    int v = arr[l];
    int j = l;
    for(int i = l + 1; i < j; i++) {
      if(v > arr[i]) {
        swap(arr, i, ++j);
      }
    }
    swap(arr, j, l);
    return j;
  }
  public void quickSort(int[] arr, int l, int r) {
    int p = partition(arr, l, r);
    quickSort(arr, l, p-1);
    quickSort(arr, p+1, r);
  }
  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }
}
