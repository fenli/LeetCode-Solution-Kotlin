package p2532_remove_letter_to_equalize_frequency

class Solution {
    fun equalFrequency(word: String): Boolean {
        val freq = mutableMapOf<Char, Int>()
        for (c in word) freq[c] = (freq[c] ?: 0) + 1
        if (freq.size == 1) return true
        
        var minF = Int.MAX_VALUE
        var maxF = Int.MIN_VALUE
        val freqOfFreq = mutableMapOf<Int, Int>()
        for ((key, value) in freq) {
            freqOfFreq[value] = (freqOfFreq[value] ?: 0) + 1
            minF = minOf(minF, value)
            maxF = maxOf(maxF, value)
            if (freqOfFreq.size > 2) return false
        }

        if (minF == maxF) return minF == 1
        if (maxF - minF > 1) return minF == 1 && freqOfFreq[minF] == 1
        return freqOfFreq[maxF] == 1 || (minF == 1 && freqOfFreq[minF] == 1)
    }
}
