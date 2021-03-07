import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.math.pow

class Gigasecond(val time: LocalDateTime) {
    constructor(dateOfBirth: LocalDate) : this(dateOfBirth.atStartOfDay())

    val date: LocalDateTime = time.plusSeconds(10.0.pow(9).toLong())
}
