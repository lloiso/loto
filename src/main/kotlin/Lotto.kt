import kotlin.random.Random

class Lotto {
    // определите поле, в котром будут храниться добавленные игроки `Person`
    val personList: MutableList<Person> = mutableListOf()

    // поле thrownNumbers должно хранить в себе набор выброшенных чисел.
    // определите подходящую структуру данных
    val thrownNumbers: MutableList<Int> = mutableListOf()

    fun addPerson(person: Person) {
        personList.add(person) // добавить игрока в список игроков
    }

    fun start() {
        // вывести сообщение "Перед началом игры необходимо добавить хотя бы двух игроков" и завершить работу,
        // если количество добавленных игроков меньше 2
        var final: Boolean = false
        var number: Int
        var winnersList: MutableList<Person> = mutableListOf()

        if (personList.size > 1) {
            // выбрасывать новые числа до тех пор, пока не определится победитель
            while (!final) {
                // достать номер. Номер может быть в диапазоне от 1 до 99 включительно
                number = Random.nextInt()

                // после каждого выброшенного числа удалять это число из карточек всех игроков, если такое число имеется
                thrownNumbers.add(number)

                for (i in 0..personList.lastIndex) {
                    personList[i].findAndRemove(number)
                    if (personList[i].card.numbers.isEmpty()){
                        winnersList.add(personList[i])
                        final = true
                    }
                }
                // побеждает тот, у кого в одном из рядов нет больше чисел. Победителей может быть более одного
            }
            if (winnersList.isNotEmpty()){
                for (i in 0..winnersList.lastIndex){
                    println("Победитель: ${winnersList[i]}!!!")
                }
            }
            // после того как появляется победитель, для каждого победителя вывести текст "Победитель: [имя_победителя]!!!"
        } else println("Перед началом игры необходимо добавить хотя бы двух игроков")
    }
}