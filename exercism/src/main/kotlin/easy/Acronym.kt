package easy

object Acronym {
    fun generate(phrase: String) : String {
        return phrase.replace("-", " ")
            .replace(Regex("[^A-Za-z0-9 ]"), "")
            .replace(Regex("[ ]{1,}"), " ").split(" ").map { it.first() }.joinToString("").toUpperCase()
    }
}
