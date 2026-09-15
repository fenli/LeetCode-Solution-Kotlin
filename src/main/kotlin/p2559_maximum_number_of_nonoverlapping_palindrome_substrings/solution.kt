package p2559_maximum_number_of_nonoverlapping_palindrome_substrings

class Solution {
    fun maxPalindromes(s: String, k: Int): Int {
        val n = s.length
        var count = 0
        var lastEnd = -1

        for (center in 0 until 2 * n - 1) {
            var left = center / 2
            var right = left + center % 2
            while (left >= 0 && right < n && s[left] == s[right]) {
                if (right - left + 1 >= k && left > lastEnd) {
                    count++
                    lastEnd = right
                    break
                }

                left--
                right++
            }
        }

        return count
    }
}
