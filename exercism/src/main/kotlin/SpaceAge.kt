import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(val age: Int) {

    fun onEarth(): Double = BigDecimal(age / 31557600.0).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    fun onMercury(): Double = BigDecimal(onEarth() / 0.2408467).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    fun onVenus(): Double = BigDecimal(onEarth() / 0.61519726).setScale(2, RoundingMode.FLOOR).toDouble()
    fun onMars(): Double = BigDecimal(onEarth() / 1.8808158).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    fun onJupiter(): Double = BigDecimal(onEarth() / 11.862615).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    fun onSaturn(): Double = BigDecimal(onEarth() / 29.447498).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    fun onUranus(): Double = BigDecimal(onEarth() / 84.016846).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    fun onNeptune(): Double = BigDecimal(onEarth() / 164.79132).setScale(2, RoundingMode.HALF_EVEN).toDouble()
}
