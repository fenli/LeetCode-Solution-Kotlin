package p0198_house_robber

fun main() {
    val solution = Solution()
    check(solution.rob(intArrayOf(1, 2, 3, 1)) == 4)
    check(solution.rob(intArrayOf(2, 7, 9, 3, 1)) == 12)
}
