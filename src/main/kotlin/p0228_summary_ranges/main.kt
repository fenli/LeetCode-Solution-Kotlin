package p0228_summary_ranges

fun main() {
    val solution = Solution()
    check(solution.summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)) == listOf("0->2", "4->5", "7"))
    check(solution.summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)) == listOf("0", "2->4", "6", "8->9"))
}
