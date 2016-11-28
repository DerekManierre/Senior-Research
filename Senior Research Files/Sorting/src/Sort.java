import java.io.*;

public class Sort {
    public static void main(String [] args) {
        double times[] = new double[1000];
        
      for(int b = 0; b < 1000; b++){
         double startTime = System.nanoTime();
        String fileName = "nums.txt";

        String line = null;
           
        int num1[] = new int[5000];
        int num2[] = new int[5000];
        int num3[] = new int[5000];
        int num1sort[] = new int[5000];
        int num3sort[] = new int[5000];
        int fill = 0;
        
        // Reading in the numbers
        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                num1[fill] = Integer.parseInt(line);
                num2[fill] = Integer.parseInt(line);
                num3[fill] = Integer.parseInt(line);
                fill++;
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
        
        // Insetion Sort Call
        num1sort = insertionSort(num1);
        
        // Quick Sort Call
        quickSort(num2, 0, num2.length -1);
        
        // Bubble Sort Call
        bubbleSort(num3);
        
        double endTime = System.nanoTime();
        double total = (endTime-startTime)/1000000000;
        times[b]= total;
    } 
      double temp = 0;
      for(int v = 0; v < 1000; v++){
          temp = temp + times[v];
      }
     double average = temp/1000;
     System.out.println(average);
    }
    
    // Insertion Sort
     public static int[] insertionSort(int[] input){
         
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
     
     // Quick Sort
     public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
		if (low >= high)
			return;
 
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j)
			quickSort(arr, low, j);
		if (high > i)
			quickSort(arr, i, high);
	}
     
     // Bubble Sort
     public static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         } 
    }
}