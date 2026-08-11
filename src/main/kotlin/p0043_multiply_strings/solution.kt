package p0043_multiply_strings

class Solution {

    val Char.number: Int
        get() = this - '0'

    fun multiply(num1: String, num2: String): String {
        val pos = IntArray(num1.length + num2.length)

        for (i in num1.length - 1 downTo 0) {
            for (j in num2.length - 1 downTo 0) {
                val mul = (num1[i].number) * (num2[j].number)
                val p1 = i + j
                val p2 = i + j + 1

                val sum = mul + pos[p2]
                pos[p1] += sum / 10
                pos[p2] = sum % 10
            }
        }

        val sb = StringBuilder()
        for (p in pos) {
            if (!(sb.isEmpty() && p == 0)) sb.append(p)
        }

        return if (sb.isEmpty()) "0" else sb.toString()
    }
}
