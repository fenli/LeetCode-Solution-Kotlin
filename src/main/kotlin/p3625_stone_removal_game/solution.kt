package p3625_stone_removal_game

class Solution {
    fun canAliceWin(n: Int): Boolean {
        var current = n
        var temp = 10
        var result = false
        while (current >= temp) {
            result = !result
            current -= temp
            temp--
        }
        return result
}
}
