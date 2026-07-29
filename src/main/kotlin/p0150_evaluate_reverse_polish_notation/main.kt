package p0150_evaluate_reverse_polish_notation

fun main() {
    val solution = Solution()
    check(solution.evalRPN(arrayOf("2", "1", "+", "3", "*")) == 9)
    check(solution.evalRPN(arrayOf("4", "13", "5", "/", "+")) == 6)
    check(solution.evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")) == 22)
}
