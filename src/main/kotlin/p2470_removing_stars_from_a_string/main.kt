package p2470_removing_stars_from_a_string

fun main() {
    val solution = Solution()
    check(solution.removeStars("leet**cod*e") == "lecoe")
    check(solution.removeStars("erase*****") == "")
}
