package p0622_calculate_maximum_information_gain

class Solution {

    private fun entropy(counts: Collection<Int>): Double {
        val total = counts.sum()
        if (total == 0) return 0.0

        var result = 0.0

        for (count in counts) {
            if (count == 0) continue

            val probability = count.toDouble() / total
            result -= probability * (ln(probability) / ln(2.0))
        }

        return result
    }

    fun calculateMaxInfoGain(petalLength: DoubleArray, species: Array<String>): Double {
        val n = petalLength.size

        if (n < 2) return 0.0

        // Sort sample indices by petal length.
        val sortedIndices = petalLength.indices
            .sortedBy { petalLength[it] }

        val totalCounts = species.groupingBy { it }.eachCount()

        val leftCounts = HashMap<String, Int>()
        val rightCounts = HashMap(totalCounts)

        val totalEntropy = entropy(totalCounts.values)

        var maxGain = 0.0

        // Split between sorted positions i - 1 and i.
        for (i in 1 until n) {
            val currentSpecies = species[sortedIndices[i - 1]]

            // Move one sample from right subgroup to left.
            leftCounts[currentSpecies] =
                (leftCounts[currentSpecies] ?: 0) + 1

            rightCounts[currentSpecies] =
                rightCounts.getValue(currentSpecies) - 1

            val leftSize = i
            val rightSize = n - i

            val leftEntropy = entropy(leftCounts.values)
            val rightEntropy = entropy(rightCounts.values)

            val weightedEntropy =
                leftSize.toDouble() / n * leftEntropy +
                rightSize.toDouble() / n * rightEntropy

            val gain = totalEntropy - weightedEntropy

            maxGain = maxOf(maxGain, gain)
        }

        return maxGain
    }
}

