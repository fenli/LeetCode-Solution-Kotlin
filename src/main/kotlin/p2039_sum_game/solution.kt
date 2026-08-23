package p2039_sum_game

class Solution {
    fun sumGame(num: String): Boolean {
        var sumLeft = 0
        var sumRight = 0
        var qLeft = 0
        var qRight = 0
        for (i in 0 until num.length / 2) if (num[i] == '?') qLeft++ else sumLeft += num[i].digitToInt()
        for (i in num.length / 2 until num.length) if (num[i] == '?') qRight++ else sumRight += num[i].digitToInt()

        return (sumLeft - sumRight).toDouble() != (4.5 * (qRight - qLeft))
    }
}
