import java.security.SecureRandom

data class Cipher(val key: String = generateKey()) {

    init {
        require(key.isNotBlank() && key.all { it.isLetter() && it.isLowerCase() })
    }


    fun encode(text: String): String {
        var keyIndex = 0
        return text.map {
            'a' + (it.toLowerCase() + key[keyIndex++ % key.length].toInt() - 194).toInt() % 26
        }.joinToString("")
    }

    fun decode(cipher: String): String {
        var keyIndex = 0
        return cipher.map {
            'a' + (it.toLowerCase() - key[keyIndex++ % key.length] + 26) % 26
        }.joinToString("")
    }
}

private fun generateKey() : String {
    val bytes = ByteArray(100)
    SecureRandom.getInstanceStrong().nextBytes(bytes)
    return bytes.map { 'a' + (it.toInt() + 128) % 26 }.joinToString("")
}
