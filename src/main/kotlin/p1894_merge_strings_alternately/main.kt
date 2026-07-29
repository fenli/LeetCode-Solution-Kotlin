package p1894_merge_strings_alternately

fun main() {
    val solution = Solution()
    check(solution.mergeAlternately("abc", "pqr") == "apbqcr")
    check(solution.mergeAlternately("ab", "pqrs") == "apbqrs")
    check(solution.mergeAlternately("abcd", "pq") == "apbqcd")
}
