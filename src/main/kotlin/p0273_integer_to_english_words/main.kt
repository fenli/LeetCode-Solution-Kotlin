package p0273_integer_to_english_words

fun main() {
    val solution = Solution()
    check(solution.numberToWords(123) == "One Hundred Twenty Three")
    check(solution.numberToWords(12345) == "Twelve Thousand Three Hundred Forty Five")
    check(solution.numberToWords(1234567) == "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven")
}
