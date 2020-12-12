package com.kotlin.mastermind

data class CodeGenerator(val codeLength : Int, val alphabet : CharRange) {

    fun generate() : String{
        return (1..codeLength)
            .map { alphabet.random() }
            .joinToString("")
    }
}