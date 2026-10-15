package p4084_maximize_sum_of_squares_of_digits

class Solution {
    fun maxSumOfSquares(num: Int, sum: Int): String {
        if (num * 9 < sum) return ""
        val builder = CharArray(num) { '0' }
        val cnt = sum / 9
        builder.fill('9', 0, cnt)
        if (cnt < num) {
            builder[cnt] += sum - cnt * 9
        }
        return String(builder)
    }
}
