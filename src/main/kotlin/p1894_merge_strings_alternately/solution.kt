package p1894_merge_strings_alternately

import kotlin.math.max

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        return buildString {
            for (i in 0 until max(word1.length, word2.length)) {
                if (i < word1.length) append(word1[i])
                if (i < word2.length) append(word2[i])
            }
        }
    }
}
