/**
 * Problem : https://leetcode.com/problems/ransom-note/description/
 * Submission : https://leetcode.com/problems/ransom-note/submissions/1907420262
 */

class Solution383 {
    fun canConstruct_alt(ransomNote: String, magazine: String): Boolean {
        var mags = magazine
        for (c in ransomNote) {
            if (mags.contains(c)) {
                mags = mags.replaceFirst(c, ' ')
            } else return false
        }
        return true
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val counterNote = mutableMapOf<Char, Int>()
        val counterMagz = mutableMapOf<Char, Int>()

        for (c in ransomNote) {
            counterNote[c] = (counterNote[c] ?: 0) + 1
        }

        for (c in magazine) {
            counterMagz[c] = (counterMagz[c] ?: 0) + 1
        }

        counterNote.forEach { (key, value) ->
            if ((counterMagz[key] ?: 0) < value) return false
        }

        return true
    }
}

fun main() {
    val solution = Solution383()
    check(!solution.canConstruct("a", "b"))
    check(!solution.canConstruct("aa", "ab"))
    check(solution.canConstruct("aa", "aab"))
}
