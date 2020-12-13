package com.kotlin.nicestring

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NiceStringCheckerTest {
    @Test
    fun test() {
        assertFalse { "bac".isNice() }
        assertFalse { "aza".isNice() }
        assertFalse { "abaca".isNice() }
        assertTrue { "baaa".isNice() }
        assertTrue { "aaab".isNice() }
    }
}