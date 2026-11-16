package p2361_calculate_digit_sum_of_a_string

class Solution {
    fun digitSum(s: String, k: Int): String {
        var digits = s
        while (digits.length > k) {           
            val sb = StringBuilder()
            var pos = 0
            var i = 0
            var sum = 0
            while (pos < digits.length) {
                sum += digits[pos] - '0'
                i++
                if (i == k) { //add string and reset current group
                    sb.append(sum)
                    sum = 0 
                    i = 0
                }
                pos++
            }
            if (i != 0) { //add string of last group
                sb.append(sum)
            }

            digits = sb.toString()
        }

        return digits
    }
}
