package p0224_basic_calculator

fun main() {
    val solution = Solution()
    check(solution.calculate("1 + 1") == 2)
    check(solution.calculate(" 2-1 + 2 ") == 3)
    check(solution.calculate("(1+(4+5+2)-3)+(6+8)") == 23)
}
