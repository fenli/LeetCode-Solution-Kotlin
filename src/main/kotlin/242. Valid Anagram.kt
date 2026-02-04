/**
 * Problem : https://leetcode.com/problems/valid-anagram/description/
 * Submission : https://leetcode.com/problems/valid-anagram/submissions/1907720598
 */

class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val sums = hashMapOf<Char, Int>()
        for (i in 0 until s.length) {
            sums[s[i]] = (sums[s[i]] ?: 0) + 1
            sums[t[i]] = (sums[t[i]] ?: 0) - 1
        }

        return sums.all { it.value == 0 }
    }
}

fun main() {
    val solution = Solution242()
    check(solution.isAnagram("anagram", "nagaram"))
    check(!solution.isAnagram("rat", "car"))
}
