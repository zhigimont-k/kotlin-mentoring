package com.kotlin.gameOfFifteen

/*
 * This function should return the parity of the permutation.
 * true - the permutation is even
 * false - the permutation is odd
 * https://en.wikipedia.org/wiki/Parity_of_a_permutation

 * If the game of fifteen is started with the wrong parity, you can't get the correct result
 *   (numbers sorted in the right order, empty cell at last).
 * Thus the initial permutation should be correct.
 */
fun isEven(permutation: List<Int>): Boolean {
    var inversionNumber = 0
    with(permutation){
        for (i in 0 until size){
            for (j in (i+1) until size){
                if (this[i] > this[j]){
                    inversionNumber++
                }
            }
        }
    }
    return inversionNumber % 2 == 0
}