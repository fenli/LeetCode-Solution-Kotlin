/**
 * Problem : https://leetcode.com/problems/reverse-words-in-a-string/description/
 * Submission : https://leetcode.com/problems/reverse-words-in-a-string/submissions/1950837665
 */

class Solution151 {
    fun reverseWords(s: String): String {
        var result = ""
        var temp = ""
        for (n in s) {
            if (n == ' ') {
                if (!temp.isEmpty()) result = temp + (if (result.isEmpty()) "" else " ") + result
                temp = ""
            } else {
                temp += n
            }
        }

        if (!temp.isEmpty()) result = temp + (if (result.isEmpty()) "" else " ") + result

        return result
    }
}

fun main() {
    val solution = Solution151()
    check(solution.reverseWords("the sky is blue") == "blue is sky the")
    check(solution.reverseWords("  hello world  ") == "world hello")
    check(solution.reverseWords("a good   example") == "example good a")
}
