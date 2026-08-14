package p3349_maximum_length_substring_with_two_occurrences

class Solution {
    fun maximumLengthSubstring(s: String): Int {
        var maxL = 0
        val map = IntArray(26)
        var start = 0
        var end = 0
        for (c in s) {
            map[c.code - 97]++
            while(map[c.code - 97] > 2) {
                map[s[start].code - 97]--
                start++
            }

            maxL = maxOf(maxL, end - start + 1)
            end++
        }

        return maxL
    }
}
