object Pangram {

    fun isPangram(input: String): Boolean {
        return ('a'..'z').all {input.contains(it, true)}
    }
}
