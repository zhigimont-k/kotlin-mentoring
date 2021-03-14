package medium

class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
    init {
        require(setOf(a, b, c).all { it.toDouble() > 0 })
        require(listOf(a, b, c).all { mutableListOf(a,b,c).apply { remove(it) }.sumByDouble { elem -> elem.toDouble() } >= it.toDouble() })
    }

    val isEquilateral: Boolean = setOf(a, b, c).size == 1
    val isIsosceles: Boolean = setOf(a, b, c).size <= 2
    val isScalene: Boolean = setOf(a, b, c).size == 3
}
