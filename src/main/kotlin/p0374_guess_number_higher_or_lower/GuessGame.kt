package p0374_guess_number_higher_or_lower

import kotlin.random.Random

abstract class GuessGame(private val pick: Int = Random.nextInt()) {
    abstract fun guessNumber(n: Int): Int

    fun guess(n: Int): Int {
        return if (n > pick) -1
        else if (n < pick) 1
        else 0
    }
}