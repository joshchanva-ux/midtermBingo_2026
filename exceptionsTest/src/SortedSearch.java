public class SortedSearch {
        public static void main(String args[]) {
            int[] first_array = null;
            int[] search_array = null;
            int[] sorted_array;
            int result;

            try{
            result = slowSearch(search_array, 5);
            System.out.println("Index of array with linear search result is " + result + "\n");
            }catch (Exception e) {
                System.out.println("slowSearch: Array is null: " + e.getMessage());
            }

            if (args.length > 0) {
                first_array = parseArgsToIntArray(args);
                return;
            }
  
            try {
            youMustDoThis(first_array);
            } catch (Exception e) {
                System.out.println("youMustDoThis: Array is null: " + e.getMessage());
            }

            result = fastSearch(search_array, 5);
            System.out.println("Index of array with binary search result is " + result + "\n");


            sorted_array = moveDataAround(search_array);
            // print out array
            System.out.println("The array after the bubble sort is:");
            for (int i = 0; i < sorted_array.length; i++) {
                    System.out.print(sorted_array[i] + " ");
            }
        
        }
        
        // O(1)
        public static void youMustDoThis(int[] arr) throws Exception {
            System.out.println("Print out the first element of array " + arr[0]);
        }

         // O(log(n))
         public static int fastSearch(int[] arr, int target) {
            int left = 0;
            int right = 0;
            try {
                right = arr.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid] == target) {
                        return mid;
                    } else if (arr[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } catch (Exception e){
                System.out.println("binarySearch: Array is null: " + e.getMessage());
            }
            return -1;
        }

        // O(n)
        public static int slowSearch(int[] arr, int target) {

            try {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == target) {
                        return i;
                    }
                }
            }
            catch (NullPointerException e) {
                System.out.println("linearSearch: Array is null: " + e.getMessage());
                throw new NullPointerException();
            }
            return -1;
        }
        
        // O(n^2)
        public static int[] moveDataAround(int[] arr){
            int n;
            try {
                n = arr.length;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (arr[j] > arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
            } catch (NullPointerException e){
                System.out.println("bubbleSort: Array is null: " + e.getMessage());
            }
            return(arr);
        }

        private static int[] parseArgsToIntArray(String[] args) {
        int[] arr = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        return arr;
    }

}
