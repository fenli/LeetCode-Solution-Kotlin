package p1777_determine_if_two_strings_are_close

fun main() {
    val solution = Solution()
    check(solution.closeStrings("abc", "bca"))
    check(!solution.closeStrings("a", "aa"))
    check(solution.closeStrings("cabbba", "abbccc"))
}
