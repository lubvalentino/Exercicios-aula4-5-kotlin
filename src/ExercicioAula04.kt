fun main() {
    //Exercicio 1
    val lista = arrayListOf(1,7,4)

    println("Resultado exercicio 1: " + lista.max())

    //Exercicio 2
    val frase = "Primeira frase"
    val frase2 = "Segunda frase"

    if (frase.equals(frase2)){
        println("Resultado exercício 2: false")
    } else{
        println("Resultado exercício 2: true")
}

    //Exercicio 3
    val numero = 10

    when{
        (numero % 2) == 0 -> {
            println("Resultado exercício 3: true")
        }
        (numero % 2) != 0 -> {
            println("Resultado exercício 3: false")
        }
    }

    //Exercicio 4
    var num = 1
    var numerosImpares = arrayListOf<Int>()
    do{
        if (num % 2 != 0){
            numerosImpares.add(num)
            num++
        }else {
            (num++)
        }}
    while (numerosImpares.size <= 99)
    println("Resultado exercício 4:" + numerosImpares)

    //Exercicio 5
    var numA = 1
    var numB = 2
    var numC = 3
    var numD = 4

    when{
        (numA > numC && numA > numD) || (numB > numC && numB > numD) -> println("Resultado do exercício 5: true")
    else ->
        println("Resultado exercício 5: false")}

    //Exercicio 6
    var numerosInteiros = arrayListOf<Int>()
    for (item in 1..100)
        numerosInteiros.add(item)
    println("Resultado exercício 6: " + numerosInteiros)
}