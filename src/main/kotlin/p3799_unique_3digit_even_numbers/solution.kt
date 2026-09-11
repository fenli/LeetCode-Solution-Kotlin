package p3799_unique_3digit_even_numbers

class Solution {
    fun totalNumbers(digits: IntArray): Int {
        val numbers = mutableSetOf<Int>()

        for (first in digits.indices) {
            if (digits[first] == 0) continue

            for (second in digits.indices) {
                if (second == first) continue

                for (third in digits.indices) {
                    if (third == first || third == second) continue
                    if (digits[third] % 2 != 0) continue

                    val number = digits[first] * 100 +
                            digits[second] * 10 +
                            digits[third]

                    numbers.add(number)
                }
            }
        }

        return numbers.size
    }
}
