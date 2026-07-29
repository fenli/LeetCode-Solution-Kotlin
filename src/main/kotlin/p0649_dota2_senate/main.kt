package p0649_dota2_senate

fun main() {
    val solution = Solution()
    check(solution.predictPartyVictory("RD") == "Radiant")
    check(solution.predictPartyVictory("RDD") == "Dire")
}
