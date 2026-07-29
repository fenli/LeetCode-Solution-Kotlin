package p0283_move_zeroes

fun main() {
    val solution = Solution()

    val n1 = intArrayOf(0, 1, 0, 3, 12)
    solution.moveZeroes(n1)
    check(n1.contentEquals(intArrayOf(1, 3, 12, 0, 0)))

    val n2 = intArrayOf(0)
    solution.moveZeroes(n2)
    check(n2.contentEquals(intArrayOf(0)))
}
