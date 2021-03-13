package medium

object Luhn {

    fun isValid(candidate: String): Boolean {
        val filtered = candidate.filterNot { it.isWhitespace() }
        if (filtered.length < 2) return false
        if (filtered.any { !it.isDigit() }) return false
        return filtered
            .map { c -> Character.getNumericValue(c) }
            .reversed()
            .mapIndexed { index, it -> if (index % 2 == 1) 2 * it else it }
            .map { if (it > 9) it - 9 else it }
            .sum() % 10 == 0
    }
}
