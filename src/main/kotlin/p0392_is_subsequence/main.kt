package p0392_is_subsequence

fun main() {
    val solution = Solution()
    check(solution.isSubsequence("abc", "ahbgdc"))
    check(!solution.isSubsequence("axc", "ahbgdc"))
}
