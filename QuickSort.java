class QuickSort 
{ 
    //Take last element as pivot
	//Move items smaller than pivot are moved to the left of pivot
	//and items greater than or equal to pivot are moved to the right
    static int partition(int arr[], int lowIndex, int highIndex) 
    { 
        int pivot = arr[highIndex];  
        int i = (lowIndex - 1); 
        for (int j = lowIndex; j < highIndex; j++) 
        { 
            // item smaller than pivot, swap 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        
        //After running through array, swap pivot value w/ 
        //item after last lowIndex item
  
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[highIndex]; 
        arr[highIndex] = temp; 
        
        
        //return pivot location
        return i + 1; 
    } 
  
  
    //Implementation of our quickSort algorithm
    public static void quickSortFunction(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            quickSortFunction(arr, low, pi-1); 
            quickSortFunction(arr, pi+1, high); 
        } 
    } 
  
} 
