package hard

import java.math.BigInteger
import kotlin.random.Random

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger {
        return BigInteger.ONE + Random.nextInt(prime.toInt() - 2).toBigInteger()
    }

    fun publicKey(p: BigInteger, g: BigInteger, privKey: BigInteger): BigInteger {
        return g.pow(privKey.toInt()).mod(p)
    }

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger {
        return publicKey.pow(privateKey.toInt()).mod(prime)
    }
}
