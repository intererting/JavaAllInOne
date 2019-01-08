import java.io.*

private fun basic() {
    val sequence = sequence<Int> {
        yield(1)
        yieldAll(0..4)
    }

    sequence.forEach {
        println(it)
    }
}

private fun copyFile() {
    val srcFile = BufferedInputStream(FileInputStream(File("d:\\test.jpg")))
    val desFile = File("d:\\copyFile.jpg")
    if (!desFile.exists()) {
        desFile.createNewFile()
    }
    val os = BufferedOutputStream(FileOutputStream(desFile))
    var hasRead: Int
    val byteArray = ByteArray(1024)
    val files = iterator {
        while (srcFile.read(byteArray).also {
                    hasRead = it
                } != -1) {
            yield(byteArray)
        }
    }

    files.forEach {
        os.write(it)
    }
}

fun main(args: Array<String>) {
    copyFile()
}