package easy

import kotlin.math.hypot

object Darts {
    private val INNER_CIRCLE_RADIUS = 1
    private val INNER_CIRCLE_SCORE = 10
    private val MIDDLE_CIRCLE_RADIUS = 5
    private val MIDDLE_CIRCLE_SCORE = 5
    private val OUTER_CIRCLE_RADIUS = 10
    private val OUTER_CIRCLE_SCORE = 1

    fun score(x: Number, y: Number): Int =
        when {
            isInInnerCircle(hypot(x.toDouble(), y.toDouble())) -> INNER_CIRCLE_SCORE
            isInMiddleCircle(hypot(x.toDouble(), y.toDouble())) -> MIDDLE_CIRCLE_SCORE
            isInOuterCircle(hypot(x.toDouble(), y.toDouble())) -> OUTER_CIRCLE_SCORE
            else -> 0
        }

    private fun isInInnerCircle(distance : Double) : Boolean = distance <= INNER_CIRCLE_RADIUS
    private fun isInMiddleCircle(distance : Double) : Boolean = distance <= MIDDLE_CIRCLE_RADIUS
    private fun isInOuterCircle(distance : Double) : Boolean = distance <= OUTER_CIRCLE_RADIUS
}
