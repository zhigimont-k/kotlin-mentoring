package com.kotlin.mastermind

import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AnswerCheckerTest {
    val illegalInputAlphabet = "56*V"
    val illegalInputLength = "ABCDE"
    val legalInput = "ABCD"

    @Test
    fun testInputValidationLengthNegative() {
        assertFalse { AnswerChecker.isInputValid(illegalInputLength) }
    }

    @Test
    fun testInputValidationAlphabetNegative() {
        assertFalse { AnswerChecker.isInputValid(illegalInputAlphabet) }
    }

    @Test
    fun testInputValidationAlphabetPositive() {
        assertTrue { AnswerChecker.isInputValid(legalInput) }
    }

    @Test
    fun checkAnswerTest(){
        var code = "ABCD"
        assertEquals(Pair(4,4), AnswerChecker.checkAnswer(legalInput, code))
        code = "ABCE"
        assertEquals(Pair(3,3), AnswerChecker.checkAnswer(legalInput, code))
        code = "ABDC"
        assertEquals(Pair(2,4), AnswerChecker.checkAnswer(legalInput, code))
        code = "EEEE"
        assertEquals(Pair(0,0), AnswerChecker.checkAnswer(legalInput, code))
    }

}