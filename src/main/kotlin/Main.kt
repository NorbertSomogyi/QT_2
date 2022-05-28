import java.io.File

fun main(args: Array<String>) {
    val network = Network(5000, 14.0)
    network.generateNetwork()

    var r = 0.0
    val averageDegrees = mutableListOf<Double>()
    val rValues = mutableListOf<Double>()
    while (r <= 18) {
        val averageDegree = network.averageDegree(r)
        println("Average degree at r = $r is $averageDegree")
        averageDegrees.add((averageDegree))
        rValues.add(r)
        r += 0.01
    }

    File("src/main/resources/AverageDegrees_Out").printWriter().use { out ->
        averageDegrees.forEach {
            out.println("$it")
        }
    }

    File("src/main/resources/RValues_Out").printWriter().use { out ->
        rValues.forEach {
            out.println("$it")
        }
    }
}