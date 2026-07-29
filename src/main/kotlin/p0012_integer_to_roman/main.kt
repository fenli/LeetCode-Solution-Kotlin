package p0012_integer_to_roman

fun main() {
    val solution = Solution()
    check(solution.intToRoman(3749) == "MMMDCCXLIX")
    check(solution.intToRoman(58) == "LVIII")
    check(solution.intToRoman(1994) == "MCMXCIV")
}
