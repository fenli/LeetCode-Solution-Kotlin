package p3275_minimum_number_of_pushes_to_type_word_i

class Solution {
    fun minimumPushes(word: String): Int {
        var minPush = 0
        var len = word.length
        var i = 1
        while (len > 0) {
            minPush += i++ * minOf(8, len)
            len -= 8
        }

        return minPush
    }
}
