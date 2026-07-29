package p0013_roman_to_integer

fun main() {
    val solution = Solution()
    check(solution.romanToInt("III") == 3)
    check(solution.romanToInt("LVIII") == 58)
    check(solution.romanToInt("MCMXCIV") == 1994)
}
