package p0007_reverse_integer

class Solution {
    fun reverse(x: Int): Int {
        var num = x
        var reversed = 0
        while (num != 0) {
            if (reversed > Int.MAX_VALUE / 10 || reversed < Int.MIN_VALUE / 10) return 0
            reversed *= 10
            reversed += num % 10
            num /= 10
        }

        return reversed
    }
}
