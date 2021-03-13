package easy

fun transcribeToRna(dna: String): String = dna.map { getRna(it) }.joinToString(separator = "")

fun getRna(dna: Char) = mapOf('G' to 'C', 'C' to 'G', 'T' to 'A', 'A' to 'U')[dna]!!
