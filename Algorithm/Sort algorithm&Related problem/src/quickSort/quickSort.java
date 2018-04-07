public class quickSort {
  public int partition(int[] arr, int l, int r) {
    int v = arr[l];
    int j = l;
    for(int i = l+1; i <= r; i++) {
      if(arr[j] < v) {
        swap(arr, ++j, i);
      }
    }
    swap(arr, l, j);
    return j;
  }
  public void sort(int[] arr, int l, int r) {
    if(l >= r) return;
    int p = partition(arr, l, p-1);
    sort(arr, l, p-1);
    sort(arr, p+1, r);
  }
  public void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }
  public void swap(int[] arr, int i, int j) {
    if(i == j) return;
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
