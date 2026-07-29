package p0020_valid_parentheses

fun main() {
    val solution = Solution()
    check(solution.isValid("()"))
    check(solution.isValid("()[]{}"))
    check(!solution.isValid("(]"))
    check(solution.isValid("([])"))
    check(!solution.isValid("([)]"))
}
