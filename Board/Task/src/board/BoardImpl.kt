package board

import board.Direction.*
import java.util.*

fun createSquareBoard(width: Int): SquareBoard {
    val board = SquareBoardImpl(width)
    board.cells = createEmptyBoard(width)
    return board
}

fun createEmptyBoard(width: Int): Array<Array<Cell>> {
    val matrix = arrayOf<Array<Cell>>()
    var column: Array<Cell>
    for (i in 1..width) {
        column = arrayOf()
        for (j in 1..width) {
            column[j-1] = Cell(i, j)
        }
        matrix[i] += column
    }
    return matrix
}

fun <T> createGameBoard(width: Int): GameBoard<T> {
    val board = GameBoardImpl<T>(width)

    return board
}

open class SquareBoardImpl(override val width: Int) : SquareBoard {
    var cells: Array<Array<Cell>> = arrayOf(arrayOf())
    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return null
    }

    override fun getCell(i: Int, j: Int): Cell {
        return cells[i - 1][j - 1]
    }

    override fun getAllCells(): Collection<Cell> = IntRange(1, width).flatMap { i: Int ->
        IntRange(1, width).map { j: Int -> getCell(i, j) }
    }.toList()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        return cells[i - 1].toList()
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        return cells[j - 1].toList()
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        return null
    }
}

class GameBoardImpl<T>(override val width: Int) : SquareBoardImpl(width), GameBoard<T> {
    override fun get(cell: Cell): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(cell: Cell, value: T?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
