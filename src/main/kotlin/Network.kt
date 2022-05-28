import kotlin.math.*
import kotlin.random.Random

class Network(private val numberOfNodes: Int, private val diskRadius: Double) {
    private val nodes: MutableList<Node> = mutableListOf()

    fun generateNetwork() {
        for (i in 1..numberOfNodes) {
            val r = Random.nextDouble(0.0, diskRadius)
            val theta = Random.nextDouble(0.0, 2 * Math.PI)
            nodes.add(Node(r, theta))
        }

        for (i in nodes.indices) {
            for (j in i + 1 until nodes.size) {
                if (nodes[i].distance(nodes[j]) <= diskRadius) {
                    nodes[i].addNeighbour(nodes[j])
                }
            }
        }
    }

    fun averageDegree(r: Double) : Double {
        val firstPart = numberOfNodes / (2 * Math.PI * (cosh(diskRadius) - 1))
        val multOp1 =

            (2 * Math.PI * (cosh(diskRadius) - 1)) - 2 * cosh(diskRadius) * (atan(
                (cosh(diskRadius) * sinh(r / 2)) / sqrt(
                    sinh(diskRadius + r / 2) * sinh(diskRadius - r / 2)
                )
            ) + asin(
                tanh(r / 2) / tanh(diskRadius)
            ))
        val multOp2 = atan(
            ((cosh(diskRadius) + cosh(r)) * sqrt(cosh(2 * diskRadius) - cosh(r))) / (sqrt(2.0) * ((sinh(diskRadius) * sinh(
                diskRadius
            )) - cosh(diskRadius) - cosh(r)) * sinh(r / 2))
        )

        val multOp3 = atan(
            ((cosh(diskRadius) - cosh(r)) * sqrt(cosh(2 * diskRadius) - cosh(r))) / (sqrt(2.0) * ((sinh(diskRadius) * sinh(
                diskRadius
            )) + cosh(diskRadius) - cosh(r)) * sinh(r / 2))
        )
        val secondPart = multOp1 + multOp2 - multOp3

        return firstPart * secondPart
    }
}