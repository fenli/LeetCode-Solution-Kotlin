/**
 * Problem : https://leetcode.com/problems/is-subsequence/description/
 * Submission : https://leetcode.com/problems/is-subsequence/submissions/1945633128
 */

class Solution392 {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length == 0) return true
        var sIndex = 0
        for (c in t) {
            if (c == s[sIndex]) sIndex++
            if (sIndex >= s.length) return true
        }

        return false
    }
}

fun main() {
    val solution = Solution392()
    check(solution.isSubsequence("abc", "ahbgdc"))
    check(!solution.isSubsequence("axc", "ahbgdc"))
}
