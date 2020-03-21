public class quickSortIdenticalKeys {
    //Two way
    //When most of element in arr is identical, the divided array will be highly unblanced.
    //We use 2 index, left index include the elements that is <= pivot, right index include the
    //elements that is >= pivot. This kind of quick sort called: Dual pivot quicksort.
    //Dual pivot Quicksort
    public int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int i = l + 1;
        int j = r;
        while(true) {
            while(i <= r && arr[i] <= v) i++;
            while(j >= l && arr[j] >= v) j--;
            if(i > j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, l);
        return j;
    }
    public void quickIndenticalSort(int[] arr, int i, int j) {
        int index = partition(arr, i, j);
        quickIndenticalSort(arr, i, index - 1);
        quickIndenticalSort(arr, index + 1, j);
    }
    public void quickSort(int[] arr) {
        quickIndenticalSort(arr, 0, arr.length - 1);
    }
    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
