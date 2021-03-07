object Transpose {

    fun transpose(input: List<String>): List<String> {
        val transpose = mutableListOf<String>()
        input.forEachIndexed { stringIndex, s ->
            s.forEachIndexed { charIndex, c ->
                // Start new transpose string and add to list
                if (transpose.size <= charIndex ) {
                    val x = "".padEnd(stringIndex, ' ') + c
                    transpose.add(x)
                    // Add to existing transpose string with padding
                } else {
                    val y = transpose[charIndex].padEnd(stringIndex, ' ') + c
                    transpose[charIndex] = y
                }
            }
        }
        return transpose
    }
}
