public class slidingWindow_temp {
    
    
    public static void main(String[] args) {
        System.out.println(longestWithAtMostKDistinct("abaccc", 2));     // Example: 4 ("accc")
        System.out.println(longestWithAtMostKDistinct("abc", 2));        // Watch out: 2 (3 means best was recorded before shrinking)
        System.out.println(longestWithAtMostKDistinct("aaaa", 1));       // Watch out: 4 (3 means length was right - left, not + 1)
        System.out.println(longestWithAtMostKDistinct("", 2));           // Watch out: 0 (empty string)
        System.out.println(maxSumOfK(new int[] {2, 1, 5, 1, 3, 2}, 3));  // Example: 9 ([5, 1, 3])
    }
}
