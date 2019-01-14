fun main(args: Array<String>) {
//    val builder = ProcessBuilder("java", "-version")
    val builder = ProcessBuilder("ping", "192.168.2.49")
    val progress = builder.start()
    val byteArray = ByteArray(1024)
    while (progress.inputStream.read(byteArray).also {

        } != -1) {
        println(String(byteArray))
    }
    Thread.sleep(1000)

//    0000 0011  00001001  00001011
}