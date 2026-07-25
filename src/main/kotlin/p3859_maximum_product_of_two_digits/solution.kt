package p3859_maximum_product_of_two_digits

class Solution {
    fun maxProduct(n: Int): Int {
        var num = n
        var n1 = -1
        var n2 = -1
        while (num > 0) {
            val digit = num % 10
            if (n1 < n2) n1 = maxOf(n1, digit)
            else n2 = maxOf(n2, digit)
            num /= 10
        }

        return n1 * n2
    }
}
