package com.kotlin.rationals

import java.lang.IllegalArgumentException
import java.math.BigInteger

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}

data class Rational(val numenator : BigInteger, val denominator : BigInteger) {
    init {
        if (denominator == BigInteger.ZERO) throw IllegalArgumentException()
    }

    fun normalize() : Rational = Rational(numenator/numenator.gcd(denominator), denominator/denominator.gcd(numenator)).fixMinus()

    fun fixMinus() : Rational = if (denominator < BigInteger.ZERO) Rational(-numenator, -denominator) else this

    operator fun plus(rational : Rational) = Rational(numenator * rational.denominator + rational.numenator * denominator,
    denominator * rational.denominator).normalize()

    operator fun minus(rational : Rational) = Rational(numenator * rational.denominator - rational.numenator * denominator,
        denominator * rational.denominator).normalize()

    operator fun times(rational : Rational) = Rational(numenator * rational.numenator,
        denominator * rational.denominator).normalize()

    operator fun div(rational : Rational) = Rational(numenator * rational.denominator,
        denominator * rational.numenator).normalize()

    operator fun unaryMinus() = Rational(-numenator, denominator).normalize()

    operator fun compareTo(rational : Rational) : Int = (normalize() - rational.normalize()).numenator.signum()

    override fun toString() : String = "$numenator${if (denominator == BigInteger.ONE) "" else "/$denominator"}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        if (this.toString() != other.toString()) return false
        return true
    }

    operator fun rangeTo(rational : Rational): Pair<Rational,Rational> = Pair(this, rational)

}

infix fun Number.divBy(i: Number): Rational = Rational(BigInteger.valueOf(this.toLong()), BigInteger.valueOf(i.toLong())).normalize()

infix fun BigInteger.divBy(i: BigInteger): Rational = Rational(this, i).normalize()

fun String.toRational() : Rational {
    val split = split("/")
    val denominator = if (split.size > 1) split[1].toBigInteger() else BigInteger.ONE
    return Rational(split[0].toBigInteger(), denominator).normalize()
}

operator fun Pair<Rational, Rational>.contains(rational: Rational): Boolean = rational >= this.first && rational <= this.second