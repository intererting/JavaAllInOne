package socket

import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.Charset

fun main(args: Array<String>) {
    val serverSocket = ServerSocket(12346)
    while (true) {
        val clientSocket = serverSocket.accept()
        handle(clientSocket!!)
    }
}

fun handle(clientSocket: Socket) {
//    Thread(Runnable {
//        while (true) {
//            clientSocket.getOutputStream().write("hahaha".toByteArray(charset = Charset.forName("utf-8")))
//            Thread.sleep(2000)
//        }
//    }).start()

    val byteArray = ByteArray(1024)

    while (clientSocket.getInputStream().read(byteArray).also {
        } != -1)
        println(String(byteArray))

}
