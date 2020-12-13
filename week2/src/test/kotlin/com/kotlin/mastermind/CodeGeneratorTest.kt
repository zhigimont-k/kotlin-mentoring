package com.kotlin.mastermind

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CodeGeneratorTest {
    val CODE_LENGTH = 5;
    val ALPHABET = '0'..'9'

    @Test
    fun testCodeLength(){
        val generatedCodeLength = CodeGenerator(CODE_LENGTH, ALPHABET).generate().length
        assertEquals(CODE_LENGTH, generatedCodeLength)
    }

    @Test
    fun testCodeAlphabet(){
        val generatedCode = CodeGenerator(CODE_LENGTH, ALPHABET).generate()
        assertTrue { generatedCode.all { ALPHABET.contains(it) } }
    }
}