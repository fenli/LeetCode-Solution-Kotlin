import kotlin.math.max

/**
 * Problem : https://leetcode.com/problems/merge-strings-alternately/description/
 * Submission : https://leetcode.com/problems/merge-strings-alternately/submissions/1950012774
 */

class Solution1768 {
    fun mergeAlternately(word1: String, word2: String): String {
        return buildString {
            for (i in 0 until max(word1.length, word2.length)) {
                if (i < word1.length) append(word1[i])
                if (i < word2.length) append(word2[i])
            }
        }
    }
}

fun main() {
    val solution = Solution1768()
    check(solution.mergeAlternately("abc", "pqr") == "apbqcr")
    check(solution.mergeAlternately("ab", "pqrs") == "apbqrs")
    check(solution.mergeAlternately("abcd", "pq") == "apbqcd")
}
