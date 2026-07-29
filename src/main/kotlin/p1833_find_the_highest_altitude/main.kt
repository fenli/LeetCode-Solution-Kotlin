package p1833_find_the_highest_altitude

fun main() {
    val solution = Solution()
    check(solution.largestAltitude(intArrayOf(-5, 1, 5, 0, -7)) == 1)
    check(solution.largestAltitude(intArrayOf(-4, -3, -2, -1, 4, 3, 2)) == 0)
}
