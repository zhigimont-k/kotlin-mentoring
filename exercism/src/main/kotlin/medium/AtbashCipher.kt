object Atbash {
    private val cipherMap = buildCipherMap()

    fun encode(input: String) = input
        .toLowerCase()
        .mapNotNull { if (it.isLetter()) cipherMap[it] else if (it.isDigit()) it else "" }
        .joinToString("")
        .chunked(5)
        .joinToString(" ")

    fun decode(input: String) = input.mapNotNull { if (it.isLetter()) cipherMap[it] else if (it.isDigit()) it else "" }
        .joinToString("")

}

private fun buildCipherMap(): Map<Char, Char> {
    val alphabet = ('a'..'z').joinToString("")
    return alphabet.zip(alphabet.reversed()).toMap()
}