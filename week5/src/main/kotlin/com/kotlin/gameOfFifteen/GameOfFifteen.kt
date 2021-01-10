package com.kotlin.gameOfFifteen

import com.kotlin.board.Cell
import com.kotlin.board.Direction
import com.kotlin.board.createGameBoard
import com.kotlin.board.*
import com.kotlin.game.Game
import com.kotlin.game2048.Game2048Initializer

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game = GameOfFifteen(initializer)

class GameOfFifteen(private val initializer: GameOfFifteenInitializer) : Game {

    private val board = createGameBoard<Int?>(4)
    override fun initialize() {
        var permutation = initializer.initialPermutation
        board.getAllCells().forEachIndexed { index, cell -> board[cell] = if (index < board.width * board.width - 1) permutation[index] else null }
    }

    override fun canMove(): Boolean = true

    override fun hasWon(): Boolean {
        val nullCell = board.find { it == null }!!
        return board.getAllCells().map { board[it] }.filterNotNull().zipWithNext { a, b -> a <= b }.all { it } &&
                nullCell.i == nullCell.j && nullCell.i == board.width
    }

    override fun processMove(direction: Direction) {
        val nullCell = board.find { it == null }!!
        var neighbourCell : Cell?

        board.apply { neighbourCell = nullCell.getNeighbour(direction.reversed()) }
        if (neighbourCell == null) return

        board[nullCell] = board[neighbourCell!!]
        board[neighbourCell!!] = null
    }

    override fun get(i: Int, j: Int): Int? = board.getCellOrNull(i,j)?.let{ board[it] }
}

