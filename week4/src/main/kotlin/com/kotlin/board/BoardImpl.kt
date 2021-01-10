package com.kotlin.board

import java.util.*
import kotlin.collections.ArrayList


fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width).create()
fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl<T>(width).create()

open class SquareBoardImpl(override val width: Int) : SquareBoard {
    private var cells = ArrayList<Cell>()

    open fun create(): SquareBoard {
        (1..width).forEach { i -> (1..width).forEach { j -> cells.add(Cell(i, j)) } }
        return this
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? =
        if (i <= width && j <= width && i != 0 && j != 0) getCell(i, j) else null

    override fun getCell(i: Int, j: Int): Cell = cells.first { it.i == i && it.j == j }

    override fun getAllCells(): Collection<Cell> = Collections.unmodifiableList(cells)

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> = if(jRange.first < jRange.last)
        cells.filter { it.i == i && it.j in jRange } else cells.filter { it.i == i && it.j in jRange }.reversed()

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> = if(iRange.first < iRange.last)
        cells.filter { it.i in iRange && it.j == j } else cells.filter { it.i in iRange && it.j == j }.reversed()

    override fun Cell.getNeighbour(direction: Direction): Cell? = when (direction) {
        Direction.UP -> getCellOrNull(i - 1, j)
        Direction.DOWN -> getCellOrNull(i + 1, j)
        Direction.RIGHT -> getCellOrNull(i, j + 1)
        Direction.LEFT -> getCellOrNull(i, j - 1)
    }
}

class GameBoardImpl<T>(override val width: Int) : GameBoard<T>, SquareBoardImpl(width) {
    private var cellValues = mutableMapOf<Cell, T?>()

    override fun get(cell: Cell): T? = cellValues[cell]

    override fun set(cell: Cell, value: T?) {
        cellValues[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> =
        cellValues.filterValues { predicate.invoke(it) }.keys

    override fun find(predicate: (T?) -> Boolean): Cell? = cellValues.filter { predicate.invoke(it.value) }.keys.first()

    override fun any(predicate: (T?) -> Boolean): Boolean = cellValues.values.any(predicate)

    override fun all(predicate: (T?) -> Boolean): Boolean = cellValues.values.all(predicate)

    override fun create(): GameBoard<T> {
        super.create()
        getAllCells().forEach { cellValues[it] = null }
        return this
    }
}

