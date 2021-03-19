package medium

object WordCount {
    private val rx = """[a-z]+'[a-z]+|[a-z0-9]+""".toRegex()

    fun phrase(s: String) = rx
        .findAll(s.toLowerCase())
        .flatMap { it.groupValues.asSequence() }
        .groupingBy { it }
        .eachCount()
}
