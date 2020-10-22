import java.util.ArrayList;
import java.util.Random;

public class SortingTest {

	public static final int maxInteger = 999999;
	/*    
	    a) generateArrays(N) - where we will generate an array of size N with random integers. 
	    b) generateOrderedArrays(N) - where we will generate an array of size N already in order
	    c) randomizeArrays[] - will randomize array
	    d) runTests - this will create all the generated Arrays, call merge sort on them, measure the time for each run and dump the size N and the time
	    e) A main method to actually runTests.
	*/
	
	public static int [] generateArray(int N){
	    int [] array = new int[N];
	    Random rand = new Random();
        //using current time to make sure we get a random seed 
        Long seed = System.currentTimeMillis();
        rand.setSeed(seed);
	    for(int i=0; i<N;i++)
	     {
	          array[i] = rand.nextInt(maxInteger);
	     }
	    return array;
	}
	
	public static int [] generateOrderedArray(int N){
	    int [] array = new int[N];
	    for(int i=0; i<N;i++)
	     {
	          array[i] = i;
	     }
	    return array;
	}
	
	public static void randomizeArray(int array[]){
		Random rand = new Random();
        //using current time to make sure we get a random seed 
        Long seed = System.currentTimeMillis();
        rand.setSeed(seed);
        
	    for(int i=0; i<array.length;i++)
	     {
	        //swap item at array[i] with a random item 
	    	
	    	int newIndex = rand.nextInt(array.length - 1);
	    	
	    	int temp = array[i]; 
	    	array[i] = array[newIndex]; 
	        array[newIndex] = temp; 
	     }
	}
	
	/* Print Array */
    static void printArray(int array[]) 
    { 
        for (int i=0; i< array.length; ++i) 
            System.out.print(array[i]+" "); 
        System.out.println(); 
    }
	
    
	public static void runTests(){
		/* Let us define our tests. We will create three different types of arrays (random, sorted, and sorted then randomized)
		
	     * N = 20000
		
		 */
		ArrayList<Integer> sizes = new ArrayList<Integer>();

		sizes.add(20000);
		sizes.add(20000);
		sizes.add(20000);

		
		/* Let us generate all these arrays in advance */
		
		ArrayList<int []> arrays = new ArrayList<int []>();
		
			arrays.add(generateArray(sizes.get(0)));
			arrays.add(generateOrderedArray(sizes.get(1)));
			arrays.add(generateOrderedArray(sizes.get(2)));
			randomizeArray(arrays.get(2));
	    
	    /* Now let us run them in a loop and measure time */
	    ArrayList<Long> timeTaken = new ArrayList<Long>();
	    
	    for(int i=0; i<sizes.size();i++)
	    {
	    	/* To avoid noise we will run 10 times and take the average */
	            
	    	long start = System.currentTimeMillis();
	    	for(int j=0; j<10;j++) {
	    		int [] toBeSorted = arrays.get(i);
	    		QuickSort.quickSortFunction(toBeSorted, 0, (toBeSorted.length-1));
	    	}
	    	
	    	long end = System.currentTimeMillis();
	    	timeTaken.add((end-start)/10);   
	    }
	
	    for(int i=0; i<sizes.size();i++)
	
	        System.out.println("Size: "+ sizes.get(i)+"         "+ "Avg Time Elapsed: " + timeTaken.get(i));
	
	    }
	
	 public static void main(String [] args)
	    {        
	        runTests();
	    }

}
