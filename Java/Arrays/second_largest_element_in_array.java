class Solution {
    public int getSecondLargest(int[] arr) {
        // Brute Force nlogn + n
        Arrays.sort(arr);
        int l = arr[arr.length-1];
        for(int i= arr.length-1;i>=0;i--){
            if(arr[i] < l){
                return arr[i];
            }
        }
        return -1;
    }

// Better Approach
class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        Arrays.sort(arr);
        int largest=-1, secondlargest = -1;
        for(int i= 0;i<arr.length;i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        for(int i= 0;i<arr.length;i++){
            if(arr[i] < largest && arr[i] > secondlargest){
                secondlargest = arr[i];
            }
        }
        return secondlargest;
    }
}

// Optimal 
  class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        Arrays.sort(arr);
        int largest= arr[1], secondlargest = -1;
        for(int i= 0;i<arr.length;i++){
            if(arr[i] > largest){
                secondlargest  = largest;
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > secondlargest){
                secondlargest = arr[i];
            }
            
        }
        return secondlargest;
    }
}

