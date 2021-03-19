class DiamondPrinter {
    fun printToList(letter: Char): List<String> {
        val upperPart = ('A'..letter).map {
            spaces(letter - it) + it + spaces( it - 'A')
        }.map {
            it + it.reversed().drop(1)
        }

        return upperPart + upperPart.asReversed().drop(1)
    }

    private fun spaces(length: Int) = " ".repeat(length)
}
