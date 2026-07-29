package p0735_asteroid_collision

fun main() {
    val solution = Solution()
    check(solution.asteroidCollision(intArrayOf(5, 10, -5)).contentEquals(intArrayOf(5, 10)))
    check(solution.asteroidCollision(intArrayOf(8, -8)).contentEquals(intArrayOf()))
    check(solution.asteroidCollision(intArrayOf(10, 2, -5)).contentEquals(intArrayOf(10)))
    check(solution.asteroidCollision(intArrayOf(3, 5, -6, 2, -1, 4)).contentEquals(intArrayOf(-6, 2, 4)))
}
