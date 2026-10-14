/*
 * Problem: {{NUMBER}}. {{TITLE}}
 * Difficulty: {{DIFFICULTY}}
 * Link: {{LINK}}
 * Pattern: {{PATTERN}}
 * Time: O(?)
 * Space: O(?)
 * Idea: (one line: what cracks it)
 * Solved: {{DATE}}
 */
import java.util.*;

public class ProblemTemplate {

    // Paste the method signature from the problem and solve it here.
    public int solve(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        ProblemTemplate s = new ProblemTemplate();
        // The examples first, then edge cases: empty, one item, duplicates, negatives, largest size.
        check(s.solve(new int[] {1, 2, 3}), 0);
    }

    // For linked list or tree problems, paste ListNode or TreeNode below this class as a non-public class.

    static void check(Object got, Object want) {
        boolean ok = Objects.deepEquals(got, want);
        System.out.println((ok ? "PASS  " : "FAIL  ") + show(got) + (ok ? "" : "   expected " + show(want)));
    }

    static String show(Object o) {
        if (o instanceof int[] a) return Arrays.toString(a);
        if (o instanceof long[] a) return Arrays.toString(a);
        if (o instanceof char[] a) return Arrays.toString(a);
        if (o instanceof boolean[] a) return Arrays.toString(a);
        if (o instanceof Object[] a) return Arrays.deepToString(a);
        return String.valueOf(o);
    }
}
