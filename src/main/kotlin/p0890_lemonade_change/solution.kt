package p0890_lemonade_change

class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        var fives = 0
        var tens = 0

        for (bill in bills) {
            when(bill) {
                5 -> fives++
                10 -> {
                   tens++
                   fives--
                   if (fives < 0) return false
                }
                20 -> {
                    fives--
                    if (tens > 0) tens--
                    else fives -= 2
                   if (fives < 0) return false
                }
            }
        }

        return true
    }
}
