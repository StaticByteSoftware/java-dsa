import java.util.*;

public class hashmap_temp {
    

    // letterCounts, pairWithSum, groupByLength — typed from memory

    // Counting with a HashMap: countLetters
        // count the number of letter in a string 
    static Map<Character,Integer> countLetters(String s){
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()){
            count.merge(c, 1, Integer::sum);
        }
        return count;
    }

    // Counting with a Hashmap: letterCounts
        // faster version of countLetters
        // counting with array when input is only 'a' to 'z'
        // no uppercase letters, only lower 
    static int[] letterCounts(String s){
        int[] freq = new int[26];
        for (char c : s.toCharArray()){
            freq[c - 'a']++;
            // 'a' -> 0, 'b' -> 1
        }return freq;
    }

    //HashMap Partner lookup
        // integers in array that add up to the target
        // Returns the two indexes, or an empty array
    static int[] pairWithSum(int[] nums, int target){
        Map<Integer, Integer> seenAt
 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seenAt.containsKey(need)){
                return new int[]{seenAt.get(need), i};
            }
            seenAt.put(nums[i], i);
        }
        return new int[0];
    }

    // HashMap Grouping
        // Grouping by a shared key
    static Map<Integer, List<String>> groupByLength(String[] words){
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String w : words){
            groups.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
        }
        return groups;
    }    

    public static void main(String[] args) {
        System.out.println(countLetters("banana"));   // Example: banana =  {a=3, b=1, n=2}
        System.out.println(Arrays.toString(letterCounts("banana")));
        System.out.println(Arrays.toString(pairWithSum(new int[] {4, 1, 7, 3}, 10)));  // Example:  [2, 3]
        System.out.println(groupByLength(new String[] {"cat", "go", "dog", "hi"}));    // Example:  {2=[go, hi], 3=[cat, dog]}
    }
}
