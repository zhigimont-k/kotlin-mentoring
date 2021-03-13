package easy

class Matrix(private val matrixAsString: String) {

    private var matrix =
        matrixAsString.trimIndent().split("\n")
            .map { row -> row.split(" ").filter { it.isNotEmpty() }.map { it.trim().toInt() } }

    fun column(colNr: Int): List<Int> = (0..matrix.lastIndex).map { matrix[it][colNr - 1] }

    fun row(rowNr: Int): List<Int> = matrix[rowNr - 1]
}
