package p0238_product_of_array_except_self

fun main() {
    val solution = Solution()
    check(solution.productExceptSelf(intArrayOf(1, 2, 3, 4)).contentEquals(intArrayOf(24, 12, 8, 6)))
    check(solution.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).contentEquals(intArrayOf(0, 0, 9, 0, 0)))
}
