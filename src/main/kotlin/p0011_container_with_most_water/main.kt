package p0011_container_with_most_water

fun main() {
    val solution = Solution()
    check(solution.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
    check(solution.maxArea(intArrayOf(1, 1)) == 1)
}
