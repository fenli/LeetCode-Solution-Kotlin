package p0032_longest_valid_parentheses

class Solution {
    fun longestValidParentheses(s: String): Int {
        val bestOpen = IntArray(s.length) { -1 }
        var maxLen = 0
        for (i in s.indices) {
            if (s[i] == ')') {
                var j = i - 1
                while (0 <= j && s[j] != '(') j = bestOpen[j] - 1
                while (1 <= j && 0 <= bestOpen[j - 1]) j = bestOpen[j - 1]

                bestOpen[i] = j
                if (j >= 0) maxLen = maxOf(maxLen, i - j + 1)
            }
        }
        return maxLen
    }
}
