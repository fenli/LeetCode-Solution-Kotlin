package p3812_smallest_palindromic_rearrangement_i

class Solution {
    fun smallestPalindrome(s: String): String {
        if (s.length <= 3) return s

        val mid = s.length / 2
        val result = CharArray(s.length)
        val sorted = PriorityQueue<Char>()
        for (i in 0 until mid) sorted.add(s[i])
        var i = 0
        while(sorted.isNotEmpty()) {
            val c = sorted.poll()
            result[s.length - 1 - i] = c
            result[i] = c
            i++
        }
        if (s.length % 2 != 0) result[mid] = s[mid]

        return result.joinToString("")
    }
}
