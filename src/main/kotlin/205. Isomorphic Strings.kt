/**
 * Problem : https://leetcode.com/problems/isomorphic-strings/description/
 * Submission : https://leetcode.com/problems/isomorphic-strings/submissions/1907441686
 */

class Solution205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        val maps = mutableMapOf<Char, Char>()
        val hasUsed = mutableMapOf<Char, Boolean>()

        for (i in 0 until s.length) {
            val cs = s[i]
            val ct = t[i]
            if (maps[cs] == null) {
                if (hasUsed[ct] == true) return false

                maps[cs] = ct
                hasUsed[ct] = true
            } else if (maps[cs] != ct) return false
        }

        return true
    }
}

fun main() {
    val solution = Solution205()
    check(solution.isIsomorphic("egg", "add"))
    check(!solution.isIsomorphic("foo", "bar"))
    check(solution.isIsomorphic("paper", "title"))
}
