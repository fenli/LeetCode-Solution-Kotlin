package p0739_daily_temperatures

fun main() {
    val solution = Solution()
    check(
        solution.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
            .contentEquals(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0))
    )
    check(solution.dailyTemperatures(intArrayOf(30, 40, 50, 60)).contentEquals(intArrayOf(1, 1, 1, 0)))
    check(solution.dailyTemperatures(intArrayOf(30, 60, 90)).contentEquals(intArrayOf(1, 1, 0)))
}
