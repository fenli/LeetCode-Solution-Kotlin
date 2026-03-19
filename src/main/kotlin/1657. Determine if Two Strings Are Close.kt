/**
 * Problem : https://leetcode.com/problems/determine-if-two-strings-are-close/description/
 * Submission : https://leetcode.com/problems/determine-if-two-strings-are-close/submissions/1952891386
 */

class Solution1657 {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val counts1 = hashMapOf<Char, Int>()
        for (c in word1) {
            counts1[c] = (counts1[c] ?: 0) + 1
        }

        val counts2 = hashMapOf<Char, Int>()
        for (c in word2) {
            counts2[c] = (counts2[c] ?: 0) + 1
        }

        for (item in counts1) if (!counts2.contains(item.key)) return false

        if (counts1.size != counts2.size) return false

        val list = mutableListOf<Int>()
        for (item in counts1) list.add(item.value)
        for (item in counts2) if (!list.remove(item.value)) return false

        return list.isEmpty()
    }
}

fun main() {
    val solution = Solution1657()
    check(solution.closeStrings("abc", "bca"))
    check(!solution.closeStrings("a", "aa"))
    check(solution.closeStrings("cabbba", "abbccc"))
}
