package p0649_dota2_senate

class Solution {
    fun predictPartyVictory(senate: String): String {
        val ba = BooleanArray(senate.length) { true }
        var radiant = 0
        var dire = 0
        var banR = 0
        var banD = 0
        var winner: String? = null

        while(winner == null) {
            for (i in senate.indices) {
                if (ba[i] == true && senate[i] == 'R') { // Radiant
                    if (banR > 0) {
                        ba[i] = false
                        banR--
                    } else {
                        radiant++
                        banD++
                    }
                } else if (ba[i] == true && senate[i] == 'D') { // Dire
                    if (banD > 0) {
                        ba[i] = false
                        banD--
                    } else {
                        dire++
                        banR++
                    }
                }

                if (i == senate.length - 1) { // Last index
                    if (radiant > 0 && dire == 0) winner = "Radiant"
                    else if (dire > 0 && radiant == 0) winner = "Dire"

                    radiant = 0
                    dire = 0
                }
            }
        }
        
        return winner!!
    }
}
