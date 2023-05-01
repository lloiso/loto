import kotlin.random.Random
import kotlin.random.nextInt

class Person(val name: String) {
    val card = Card(createCard())

    private fun createCard(): MutableMap<Int, MutableSet<Int>> {
        val mapa = mutableMapOf<Int, MutableSet<Int>>()

        for (i in 1..3) {
            mapa.put(i, createSet())
        }
        return mapa
    }

    private fun createSet(): MutableSet<Int> {
        val mutableSet = mutableSetOf<Int>()

        while (mutableSet.size < 6) {
            mutableSet.add(Random.nextInt(1..99))
        }
        return mutableSet
    }
}