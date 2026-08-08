package p3584_find_the_lexicographically_smallest_valid_sequence

class Solution {

    fun validSequence(word1: String, word2: String): IntArray {
        val n = word1.length
        val m = word2.length

        val last = IntArray(m) { -1 }
        var j = m - 1

        for (i in n - 1 downTo 0) {
            if (j >= 0 && word1[i] == word2[j]) {
                last[j] = i
                j--
            }
        }

        val res = IntArray(m)
        var skip = false
        j = 0

        for (i in 0 until n) {
            if (j == m) break

            if (word1[i] == word2[j] || (!skip && (j == m - 1 || i < last[j + 1]))) {
                if (word1[i] != word2[j]) skip = true
                res[j] = i
                j++
            }
        }

        return if (j == m) res else intArrayOf()
    }
}
