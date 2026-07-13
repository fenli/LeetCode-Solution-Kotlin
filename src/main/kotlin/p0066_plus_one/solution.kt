package p0066_plus_one

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var carry = 1
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] == 9 && carry == 1) {
                digits[i] = 0
                carry = 1
            } else {
                digits[i] = digits[i] + carry
                carry = 0
            }

            if (carry == 0) break
        }

        return if (digits[0] == 0) intArrayOf(1) + digits else digits
    }
}
