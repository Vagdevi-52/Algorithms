package algorithms;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

	// merges two subarrays of array[].
    void merge(T[] array, int start, int middle, int end)
    {
        T[] leftArray  = (T[]) new Comparable[middle - start + 1];
        T[] rightArray = (T[]) new Comparable[end - middle];

        // fill in left array
        for (int i = 0; i < leftArray.length; ++i)
            leftArray[i] = array[start + i];

        // fill in right array
        for (int i = 0; i < rightArray.length; ++i)
            rightArray[i] = array[middle + 1 + i];

        /*  Merge the temp arrays */

        // initial indexes of first and second subarrays
        int leftIndex = 0, rightIndex = 0;

        // the index we will start by adding the subarrays back into the main array
        int currentIndex = start;

        // compare each index of the subarrays  by adding the low value to the currentIndex
        while (leftIndex < leftArray.length && rightIndex < rightArray.length)
        {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0)
            {
                array[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            }
            else
            {
                array[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

        // remaining elements of leftArray[]
        while (leftIndex < leftArray.length) array[currentIndex++] = leftArray[leftIndex++];

        // remaining elements of rightArray[]
        while (rightIndex < rightArray.length) array[currentIndex++] = rightArray[rightIndex++];
    }
    // main function that sorts start..end using merge()
    void mergeSort(T[] array, int start, int end)
    {
        // base case
        if (start < end)
        {
            // find the middle point between start to end.
            int middle = (start + end) / 2;

            mergeSort(array, start, middle); // sort first half
            mergeSort(array, middle + 1, end);  // sort second half

            // merge the sorted halves values.
            merge(array, start, middle, end);
        }
    }
    
    public static void main(String[] args) {
    	 String[] arrayOfStrings = {"Time", "is", "valuable", "dont", "waste", "your","time"};
         MergeSort<String> stringSorter   = new MergeSort<>();
         stringSorter.mergeSort(arrayOfStrings, 0, arrayOfStrings.length - 1);
         System.out.println("Array after sorting ::\n"+Arrays.toString(arrayOfStrings));
	}
    
}
