import java.util.Arrays;

public class twoPointers_temp {
    
    // Two Pointers pairInSorted
        // Opposite ends on a sorted array
        // return the two indexes or an empty array
    static int[] pairInSorted(int[] sorted, int target){
        int left = 0, right = sorted.length - 1;
        while (left < right){
            int sum = sorted[left] + sorted[right];
            if (sum == target) return new int[] {left, right};
            if (sum < target) left++;
            else right--;
        }
        return new int[0];
    } 
    
    // Two Pointer Palindrome
        // opposite ends with a smmetric check 
    static boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }return true;
    }

    // Two Pointer Remove Duplicates
    static int removeDuplicates(int[] sorted){
        if (sorted.length == 0) return 0;
        int write = 1;
        for (int read = 1; read < sorted.length; read++){
            if (sorted[read] != sorted[write - 1]) sorted[write++] = sorted[read];
        }
        return write;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairInSorted(new int[] {1, 3, 4, 6, 9}, 13)));  // Example: [2, 4]
        //System.out.println(Arrays.toString(pairInSorted(new int[] {5}, 10)));              // Watch out: [] (with <= you'd get [0, 0])
        System.out.println(isPalindrome("racecar"));    // Example: true
        System.out.println(isPalindrome("Race car"));   // Watch out: false, it compares raw characters

        int[] nums = {1, 1, 2, 3, 3};                   // keep a reference, the method edits this array
        int k = removeDuplicates(nums);
        System.out.println(k + " " + Arrays.toString(nums));   // Example: 3 [1, 2, 3, 3, 3] (first k slots are the unique values)
    }
}
