package p0202_happy_number

class Solution {
    fun isHappy(n: Int): Boolean {
        val history = hashSetOf<Int>()
        var number = n
        while(number != 1) {
            number = sumOfSquare(number)
            if (history.contains(number)) return false
            else history.add(number)
        }

        return true
    }

    fun sumOfSquare(number: Int): Int {
        if (number < 10) return number * number
        val digits = number.toString()
        var sums = 0
        for (c in digits) {
            val d  = c.digitToInt()
            sums += d*d
        }
        return sums
    }
}
