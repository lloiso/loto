import kotlin.random.Random

class Lotto {

    private val persons: MutableList<Person> = mutableListOf()
    val thrownNumbers: MutableSet<Int> = mutableSetOf()

    fun addPerson(person: Person) {
        persons.add(person)
    }

    fun start() {
        if (persons.size < 2) {
            println("Перед началом игры необходимо добавить хотя бы двух игроков")
        } else {
            do {
                val number = throwNumber()

                for (person in persons) {
                    val cardNumbers = person.card.numbers
                    for (key in cardNumbers.keys) {
                        cardNumbers[key]?.remove(number)
                    }
                }
            } while (!hasWinners())
        }
    }

    private fun throwNumber(): Int {
        val number = Random.nextInt(1, 100)

        return if (thrownNumbers.contains(number)) {
            throwNumber()
        } else {
            thrownNumbers.add(number)
            println("Выброшенное число: $number")
            number
        }
    }

    private fun hasWinners(): Boolean {
        val winners: MutableList<Person> = mutableListOf()

        for (person in persons) {
            val cardNumbers = person.card.numbers
            for (key in cardNumbers.keys) {
                if (cardNumbers[key]?.isEmpty() == true) {
                    winners.add(person)
                }
            }
        }

        return if (winners.isEmpty()) {
            false
        } else {
            for (winner in winners) {
                println("Победитель: ${winner.name}!!!")
            }
            true
        }
    }
}