fun main(args: Array<String>) {
    print(test { a, b -> a + b })
}

fun test(a: (Int, Int) -> Int): Int {
    return (a(3, 3))
}
