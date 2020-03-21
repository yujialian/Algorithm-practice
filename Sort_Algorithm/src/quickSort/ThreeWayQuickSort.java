public class ThreeWayQuickSort {
  /*After sort: [[<V][==V][>V]].*/
  /*Benifits: Don't need consider the elements that equals to pivot value.*/
  public int sort(int[] arr, int l, int r) {
    if(r - l <= 15) {
      insertionSort(arr,l, r);
      return;
    }
    swap(arr, l, (int)(Math.random()*(r-l+1)) + l);
    int v = arr[l];
    int gt = r+1;
    int st = l;
    int i = l+1;
    if(arr[i] < v) {
      swap(arr, i, ++st);
      i++;
    } else if(arr[i] > v) {
      swap(arr, i, --gt);
    } else {
      i++;
    }
    swap(arr, l, st);
    sort(arr, l, st - 1);
    sort(arr, gt, r);
  }
  public void quick3WaySort(int[] arr, int n) {
    sort(arr, 0, n-1);
  }
  private int swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
