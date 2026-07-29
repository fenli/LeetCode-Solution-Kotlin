package p0290_word_pattern

fun main() {
    val solution = Solution()
    check(solution.wordPattern("abba", "dog cat cat dog"))
    check(!solution.wordPattern("abba", "dog cat cat fish"))
    check(!solution.wordPattern("aaaa", "dog cat cat dog"))
}
