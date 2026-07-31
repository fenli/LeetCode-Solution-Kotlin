package p3276_minimum_number_of_pushes_to_type_word_ii

class Solution {
    fun minimumPushes(word: String): Int {
        if (word.length <= 8) return word.length
        val map = mutableMapOf<Char, Int>()
        for (c in word) map[c] = (map[c] ?: 0) + 1
        if (map.size <= 8) return word.length

        var minPush = 0
        val sorted = map.values.sortedDescending()
        for (i in sorted.indices) {
            minPush += sorted[i] * ((i / 8) + 1)
        }

        return minPush
    }
}
