package p0338_counting_bits

fun main() {
    val solution = Solution()
    check(solution.countBits(2).contentEquals(intArrayOf(0, 1, 1)))
    check(solution.countBits(5).contentEquals(intArrayOf(0, 1, 1, 2, 1, 2)))
}
