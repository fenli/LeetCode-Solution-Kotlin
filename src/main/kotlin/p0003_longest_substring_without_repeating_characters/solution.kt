package p0003_longest_substring_without_repeating_characters

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 0) return 0
        if (s.length == 1) return 1

        val chars = mutableSetOf<Char>()
        chars.add(s[0])
        var longest = 1
        var start = 0
        var end = 1

        while(end < s.length) {
            if (!chars.contains(s[end])) {
                chars.add(s[end])
                longest = maxOf(longest, end - start + 1)
            } else {
                while(s[start] != s[end]) {
                    chars.remove(s[start])
                    start++
                }
                start++
            }

            end++
        }

        return longest
    }
}
