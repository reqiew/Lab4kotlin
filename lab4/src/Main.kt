import kotlin.random.Random

fun main(){
    println("Введите число от 1 до 3 по порядку заданий")
    val ed = readLine()!!.toInt()
    if (ed == 1)
    {
        println("Кол-во чисел которые больше своих соседей = ${MutList()}")
    }
    else if (ed == 2)
    {
        MutSet()
    }
    else if (ed == 3){
        val inputCountries = listOf(
            "Россия Москва Санкт-Петербург",
            "США Нью-Йорк Лос-Анджелес",
            "Франция Париж Лион"
        )
        val inputQueries = listOf(
            "Москва",
            "Нью-Йорк",
            "Токио"
        )
        println("")
        println(

            "Входные данные  = \n"+
            "Россия Москва Санкт-Петербург \n"+
            "США Нью-Йорк Лос-Анджелес \n"+
            "Франция Париж Лион")
        println("")
        println("Что мы запрашиваем = \n"+
            "Москва \n"+
            "Нью-Йорк \n"+
            "Токио \n")
        MutMap(inputCountries,inputQueries)
    }




}
//List

fun MutList():Int{
    val numbers: MutableList<Int> = MutableList(10) { Random.nextInt(1, 101) }
    var count = 0
    println("List = ${numbers}")
    for (i in 1 until numbers.size-1){

        if (numbers[i] > numbers[i-1] && numbers[i] > numbers[i+1]){
            count++
        }
    }
    return count
}

//Set

fun MutSet(){
    val totalStudents = 40
    val a = 25
    val b = 22
    val c = 22
    val aOrB = 33
    val aOrC = 32
    val bOrC = 31
    val allThree = 10


    val ab = aOrB - (allThree + a + b - totalStudents)
    val ac = aOrC - (allThree + a + c - totalStudents)
    val bc = bOrC - (allThree + b + c - totalStudents)

    val x = a - (ab + allThree + ac)//прочли только A
    val y = b - (ab + allThree + bc)//прочли только B
    val z = c - (ac + allThree + bc)//прочли только C

    val onlyOneBook = x + y + z
    val exactlyTwoBooks = ab + ac + bc
    val noBooks = totalStudents - (onlyOneBook + exactlyTwoBooks + allThree)

    // Выводим результаты
    println("Количество учеников, прочитавших только одну книгу: $onlyOneBook")
    println("Количество учеников, прочитавших ровно две книги: $exactlyTwoBooks")
    println("Количество учеников, не прочитавших ни одной книги: $noBooks")
}

//map

fun MutMap(inputCountries : List<String>,inputQueries: List<String> ){


    // Читаем количество строк с странами и городами
    val numberOfCountries = inputCountries.size
    val cityToCountryMap = mutableMapOf<String, String>()

    // Читаем строки с странами и городами
    for (i in 0 until numberOfCountries) {
        val input = inputCountries[i].split(" ")
        val country = input[0]
        val cities = input.drop(1) // Получаем список городов, пропуская название страны

        // Заполняем карту с городами и странами
        for (city in cities) {
            cityToCountryMap[city] = country
        }
    }

    // Читаем количество запросов по городам
    val numberOfQueries = inputQueries.size
    val results = mutableListOf<String>()

    // Обрабатываем запросы по городам
    for (i in 0 until numberOfQueries) {
        val city = inputQueries[i]
        val country = cityToCountryMap[city]
        if (country != null) {
            results.add(country)
        } else {
            results.add("Город не найден") // Если город не найден
        }
    }

    // Выводим результаты
    results.forEach { println(it) }

}