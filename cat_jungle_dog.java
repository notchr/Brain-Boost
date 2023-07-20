import java.util.*; 

public class BrainBoost {
 
  public static void main(String[] args) {
	
 // Create an arrayList of type Integer
	ArrayList<Integer> elements = new ArrayList<Integer>();
	
	// Loop through and add 50 values to the array
	for(int i = 0; i < 50; i++){
		elements.add(i);
	}
	
	// Create a sorting function to sort the Array
	// using the bubble sort technique
	for(int i = 0; i < elements.size() - 1; i++){
		for(int j = 0; j < elements.size() - 1; j++){
			if(elements.get(j+1) > elements.get(j)){
				int temp = elements.get(j+1);
				elements.set(j+1, elements.get(j));
				elements.set(j, temp);
			}
		}
	}
	
	// Print out the sorted array
	for(int i = 0; i < elements.size(); i++) {
		System.out.println(elements.get(i));
	}
	
	// Create a method to reverse the Array
	public static void reverseArray(ArrayList<Integer> arr) {
		// Create an empty array to contain the reversed Array
		ArrayList<Integer> reversed = new ArrayList<Integer>();
		
		// Loop through the original Array from end to start and
		// add the values to the reversed array
		for(int i = arr.size()-1; i >= 0; i--) {
			reversed.add(arr.get(i));
		}
		
		// Print out the reversed array
		for(int i = 0; i < reversed.size(); i++) {
			System.out.println(reversed.get(i));
		}
	}
	
	// Reverse the original array
	reverseArray(elements);
	
	// Create a method to find the longest sequence of increasing integers
	public static void findLongestSequence(ArrayList<Integer> arr) {
		// Create an int to store the longest chain
		int longestChain = 0;
		
		// Create an int to store the current chain
		int currentChain = 0;
		
		// Loop through array
		for(int i = 0; i < arr.size()-1; i++) {
			if(arr.get(i+1) > arr.get(i)) {
				// If the next element is larger than the previous, increase the
				// current chain
				currentChain++;
			} else {
				// If the next element is smaller than the previous, compare it
				// to the longest chain
				if(currentChain > longestChain) {
					longestChain = currentChain;
				}
				// Reset the current chain
				currentChain = 0;
			}
		}
		
		// Compare the final chain to the longest chain
		if (currentChain > longestChain) {
			longestChain = currentChain;
		}
		
		// Print out the longest chain
		System.out.println("The longest chain is " + longestChain + " elements long.");
	}
	
	// Find the longest sequence in the array
	findLongestSequence(elements);
	
	// Create a method to check if an element is present in the array
	public static boolean findElement(ArrayList<Integer> arr, int element) {
		// Loop through array and compare each element
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) == element) {
				return true;
			}
		}
		
		return false;
	}
	
	// Check if the element 15 is present in the array
	boolean foundElement = findElement(elements, 15);
	System.out.println("The element is present in the array: " + foundElement);
	
	// Create a method to find the sum of the elements in the array
	public static int sumElements(ArrayList<Integer> arr) {
		// Create an int to store the sum
		int sum = 0;
		
		// Loop through array and add each element
		for(int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
		}
		
		return sum;
	}
	
	// Find the sum of the elements in the array
	int totalSum = sumElements(elements);
	System.out.println("The sum of the elements in the array is: " + totalSum);
	
	// Create a method to find the average of the elements in the array
	public static double findAverage(ArrayList<Integer> arr) {
		// Create an int to store the sum
		int sum = 0;
		
		// Loop through array and add each element
		for(int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
		}
		
		// Return the average
		return (double)sum/arr.size();
	}
	
	// Find the average of the elements in the array
	double average = findAverage(elements);
	System.out.println("The average of the elements in the array is: " + average);
	
  }
  
}