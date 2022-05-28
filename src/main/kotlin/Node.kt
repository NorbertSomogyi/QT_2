import kotlin.math.abs
import kotlin.math.ln
import kotlin.math.sin

data class Node(val r: Double, val theta: Double) {
    private val neighbours = mutableListOf<Node>()

    fun distance(other: Node) : Double {
        val dTheta = Math.PI - abs(Math.PI - abs(theta - other.theta))
        return r + other.r + 2 * ln(sin(dTheta / 2))
    }

    fun addNeighbour(node: Node) {
        neighbours.add(node)
    }
}