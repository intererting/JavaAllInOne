import java.io.FileInputStream
import java.lang.StringBuilder

fun main(args: Array<String>) {

    val fs = FileInputStream("d:\\ClazzTest.class")
    val byteArray = ByteArray(1)
    val hexString = arrayListOf<String>()
    while (fs.read(byteArray) != -1) {
        if (byteArray[0] in 16..0xff) {
            hexString.add(Integer.toHexString(byteArray[0].toInt()))
        } else if (byteArray[0] in 0x0..0xf) {
            //对于只有1位的16进制数前边补“0”
            hexString.add("0" + Integer.toHexString(byteArray[0].toInt()))
        } else {
            //对于int<0的位转化为16进制的特殊处理，因为Java没有Unsigned int，所以这个int可能为负数
            hexString.add(Integer.toHexString(byteArray[0].toInt()).substring(6))
        }
    }
//    print(hexString)
//    print(hexString.subList(0, 4)) //魔数 [ca, fe, ba, be]
//    print(hexString.subList(4, 8)) //版本号 [00, 00, 00, 34] 52 jdk8
//    print(hexString.subList(8, 10)) //[00, 0d] 13//常量池大小
    print(hexString.subList(10, 11))
//    11001010 ->11001001-> 10110110 2+4+16+32
//    00110110 -> 1...11001001-> 1...11001010 ffffffCA
}