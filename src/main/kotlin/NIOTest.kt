import java.io.RandomAccessFile
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Paths

fun main(args: Array<String>) {
    testSelector()

}

private fun testSelector() {
    val file = RandomAccessFile("d:\\test.txt", "rw")
    val outFile = RandomAccessFile("d:\\copytest.txt", "rw")
    val channel = file.channel
    val outChannel = outFile.channel
    val mapBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size())
    outChannel.write(mapBuffer)
    outChannel.force(true)
    channel.close()
    outChannel.close()
}

private fun testChannel() {
    val file = RandomAccessFile("d:\\test.txt", "rw")
    val channel = file.channel
    val byteBuffer = ByteBuffer.allocate(1024)
    var hasRead = -1
    while (channel.read(byteBuffer).also {
            hasRead = it
        } != -1) {
        byteBuffer.flip()
//        val byteArray = ByteArray(hasRead)
        for (i in 0 until hasRead) {
//            byteArray[i] = byteBuffer.get(i)
        }
        byteBuffer.clear()
//        println(String(byteArray))
    }
    file.close()
}