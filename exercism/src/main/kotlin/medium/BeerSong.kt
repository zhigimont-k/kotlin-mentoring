package medium

object BeerSong {
    fun verses(startBottles: Int, takeDown: Int) : String {
        return (startBottles downTo takeDown).joinToString("\n") {
            when (it) {
                0 -> "No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
                1 -> "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take it down and pass it around, no more bottles of beer on the wall.\n"
                else -> "$it bottles of beer on the wall, $it bottles of beer.\n" +
                        "Take one down and pass it around, ${it - 1} bottle${if (it - 1 != 1) "s" else ""} of beer on the wall.\n"
            }
        }
    }
}
