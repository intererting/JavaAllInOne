package socket

import java.net.Socket

fun main(args: Array<String>) {
    val clientSocket = Socket("localhost", 12346)
    val byteArray = ByteArray(3)
    var hasRead = -1

    while (clientSocket.getInputStream().read(byteArray).also {
                hasRead = it
            } != -1)
        println(String(byteArray))
}