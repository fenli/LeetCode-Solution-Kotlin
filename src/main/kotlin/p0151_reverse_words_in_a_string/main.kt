package p0151_reverse_words_in_a_string

fun main() {
    val solution = Solution()
    check(solution.reverseWords("the sky is blue") == "blue is sky the")
    check(solution.reverseWords("  hello world  ") == "world hello")
    check(solution.reverseWords("a good   example") == "example good a")
}
