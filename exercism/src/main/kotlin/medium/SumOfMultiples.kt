package medium

object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        return (0 until limit).filter { factors.any { factor -> factor != 0 && it % factor == 0} }.sum()
    }
}
