package p0383_ransom_note

fun main() {
    val solution = Solution()
    check(!solution.canConstruct("a", "b"))
    check(!solution.canConstruct("aa", "ab"))
    check(solution.canConstruct("aa", "aab"))
}
