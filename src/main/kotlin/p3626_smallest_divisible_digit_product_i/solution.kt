package p3626_smallest_divisible_digit_product_i

class Solution {
    fun smallestNumber(n: Int, t: Int): Int {
        var ans = n
        while(digitProduct(ans) % t != 0) ans++
        return ans
    }

    fun digitProduct(n: Int): Int {
        return if(n < 10) n else n % 10 * digitProduct(n / 10)
    }
}

