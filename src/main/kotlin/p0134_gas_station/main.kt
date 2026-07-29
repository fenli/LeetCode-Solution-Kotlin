package p0134_gas_station

fun main() {
    val solution = Solution()
    check(solution.canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)) == 3)
    check(solution.canCompleteCircuit(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)) == -1)
}
