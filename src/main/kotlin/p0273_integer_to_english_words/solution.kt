package p0273_integer_to_english_words

class Solution {
    private val maps = hashMapOf(
        1 to "One",
        2 to "Two",
        3 to "Three",
        4 to "Four",
        5 to "Five",
        6 to "Six",
        7 to "Seven",
        8 to "Eight",
        9 to "Nine",
        10 to "Ten",
        11 to "Eleven",
        12 to "Twelve",
        13 to "Thirteen",
        14 to "Fourteen",
        15 to "Fifteen",
        16 to "Sixteen",
        17 to "Seventeen",
        18 to "Eighteen",
        19 to "Nineteen",
        20 to "Twenty",
        30 to "Thirty",
        40 to "Forty",
        50 to "Fifty",
        60 to "Sixty",
        70 to "Seventy",
        80 to "Eighty",
        90 to "Ninety",
        100 to "Hundred",
        1000 to "Thousand",
        1000000 to "Million",
        1000000000 to "Billion"
    )
    private val sortedK = maps.keys.sortedDescending()

    fun numberToWords(num: Int): String {
        if (num == 0) return "Zero"

        var num = num
        val result = mutableListOf<String>()
        for (k in sortedK) {
            if (num >= k) {
                val count: Int = num / k
                
                if (count <= 20) {
                    if (k >= 100) result.add(maps[count] ?: "")
                } else {
                    result.add(numberToWords(count))
                }

                num = num - (k * count)
                result.add(maps[k] ?: "")
            }
        }
        
        return result.joinToString(" ")
    }
}

