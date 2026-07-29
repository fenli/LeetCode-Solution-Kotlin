package p0605_can_place_flowers

fun main() {
    val solution = Solution()
    check(solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
    check(!solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2))
}
