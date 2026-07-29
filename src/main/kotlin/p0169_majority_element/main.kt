package p0169_majority_element

fun main() {
    val solution = Solution()
    check(solution.majorityElement(intArrayOf(3, 2, 3)) == 3)
    check(solution.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)) == 2)
}
