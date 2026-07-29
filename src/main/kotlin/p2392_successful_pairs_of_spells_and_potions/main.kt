package p2392_successful_pairs_of_spells_and_potions

fun main() {
    val solution = Solution()
    check(
        solution.successfulPairs(
            spells = intArrayOf(5, 1, 3),
            potions = intArrayOf(1, 2, 3, 4, 5),
            success = 7
        ).contentEquals(intArrayOf(4, 0, 3))
    )
    check(
        solution.successfulPairs(
            spells = intArrayOf(3, 1, 2),
            potions = intArrayOf(8, 5, 8),
            success = 16
        ).contentEquals(intArrayOf(2, 0, 2))
    )
}
