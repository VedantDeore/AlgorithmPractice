import java.util.Arrays;
// Explained arrray
public class ArrayDemo {

    public static void main(String[] args) {
        
        // 1. Single-Dimensional Array Declaration
        int[] arr1 = new int[5]; // Default initialization with 0
        int[] arr2 = {1, 2, 3, 4, 5}; // Static initialization

        // 2. Array Operations on Single-Dimensional Arrays
        arr1[0] = 10; // Assigning values
        System.out.println("Element at index 0: " + arr1[0]);
        
        // Array length
        System.out.println("Length of arr2: " + arr2.length);

        // Array Traversal
        System.out.println("Elements of arr2:");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Sorting
        Arrays.sort(arr2);
        System.out.println("Sorted arr2: " + Arrays.toString(arr2));

        // Searching (binary search after sorting)
        int index = Arrays.binarySearch(arr2, 4);
        System.out.println("Index of 4 in arr2: " + index);

        // Copying Arrays
        int[] arr3 = Arrays.copyOf(arr2, arr2.length);
        System.out.println("Copied array (arr3): " + Arrays.toString(arr3));

        // Filling an array with a single value
        Arrays.fill(arr1, 9);
        System.out.println("Filled arr1 with 9: " + Arrays.toString(arr1));

        // 3. Multi-Dimensional Arrays (2D)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("\n2D Array (Matrix):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 4. Jagged Arrays (Array of arrays with different lengths)
        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[]{1, 2};
        jaggedArray[1] = new int[]{3, 4, 5};
        jaggedArray[2] = new int[]{6};

        System.out.println("\nJagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }

        // 5. 3D Arrays
        int[][][] threeDArray = {
            {
                {1, 2, 3}, 
                {4, 5, 6}
            },
            {
                {7, 8, 9}, 
                {10, 11, 12}
            }
        };

        System.out.println("\n3D Array:");
        for (int i = 0; i < threeDArray.length; i++) {
            for (int j = 0; j < threeDArray[i].length; j++) {
                for (int k = 0; k < threeDArray[i][j].length; k++) {
                    System.out.print(threeDArray[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 6. Functions in Arrays Class
        // Equals (compare two arrays)
        boolean isEqual = Arrays.equals(arr2, arr3);
        System.out.println("Are arr2 and arr3 equal? " + isEqual);
    }
}
