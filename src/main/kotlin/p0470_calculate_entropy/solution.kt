package p0470_calculate_entropy

class Solution {
    fun calculateEntropy(input: IntArray): Double {
        if (input.isEmpty()) return 0.0

        val frequency = HashMap<Int, Int>()

        for (value in input) {
            frequency[value] = (frequency[value] ?: 0) + 1
        }

        val n = input.size
        var entropy = 0.0

        for (count in frequency.values) {
            val probability = count.toDouble() / n

            entropy -= probability * (ln(probability) / ln(2.0))
        }

        return entropy
    }
}

