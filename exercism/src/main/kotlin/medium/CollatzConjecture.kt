object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        require(start > 0)
        return generateSequence(start) { if (it % 2 == 0) it / 2 else it * 3 + 1 }
            .takeWhile { it != 1 }
            .count()
    }
}
