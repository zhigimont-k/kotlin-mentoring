import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    val abs by lazy { sqrt(real * real + imag * imag) }

    operator fun plus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real + other.real, imag + other.imag)
    }

    operator fun minus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real - other.real, imag - other.imag)
    }

    operator fun times(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real * other.real - imag * other.imag, real * other.imag + other.real * imag)
    }

    operator fun div(other: ComplexNumber): ComplexNumber {
        return (this * other.conjugate()) / (other.real * other.real + other.imag * other.imag)
    }

    operator fun div(other: Double): ComplexNumber {
        return ComplexNumber(real / other, imag / other)
    }

    fun conjugate() : ComplexNumber = ComplexNumber(real, -imag)

}

fun exponential(n: ComplexNumber): ComplexNumber = ComplexNumber(exp(n.real)) * ComplexNumber(cos(n.imag), sin(n.imag))
