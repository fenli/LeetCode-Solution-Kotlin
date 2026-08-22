package p3918_check_divisibility_by_digit_sum_and_product

class Solution {
    fun checkDivisibility(n: Int): Boolean {
        var number = n
        var sum = 0
        var product = 1
        while (number > 0) {
            val digit = number % 10
            sum += digit
            product *= digit
            number /= 10
        }

        return n % (sum + product) == 0
    }
}
