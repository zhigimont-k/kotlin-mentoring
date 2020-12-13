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
        assertEquals(Pair(4,0), AnswerChecker.checkAnswer("ABCD", "ABCD"))
        assertEquals(Pair(0,4), AnswerChecker.checkAnswer("CDBA", "ABCD"))
        assertEquals(Pair(2,2), AnswerChecker.checkAnswer("ABDC", "ABCD"))
        assertEquals(Pair(1,0), AnswerChecker.checkAnswer("ADFE", "AABC"))
        assertEquals(Pair(1,1), AnswerChecker.checkAnswer("ADFA", "AABC"))
        assertEquals(Pair(0,2), AnswerChecker.checkAnswer("DFAA", "AABC"))
        assertEquals(Pair(0,1), AnswerChecker.checkAnswer("DEFA", "AABC"))
    }

}