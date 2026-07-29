package p0027_remove_element

fun main() {
    val solution = Solution()
    check(solution.removeElement(intArrayOf(3, 2, 2, 3), 3) == 2)
    check(solution.removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2) == 5)
}
