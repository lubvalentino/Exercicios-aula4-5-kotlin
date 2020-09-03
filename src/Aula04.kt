fun main() {

    var num = 7
    var num2 = 2

    println("A soma é ${num + num2}")

    println("A subtração é ${num - num2}")

    println("A divisão é ${num / num2}")

    println("A multiplicação é ${num * num2}")

    num++

    println("O novo número é $num")

    num += num2

    println(num)

    num--

    println(num)

    num -= num2

    print("Essa linha não vai quebrar $num")

    val pontoFlutuante = 5.0

    println("A soma de um inteiro e um ponto flutuante é ${pontoFlutuante + num}")
    println("Essa linha quebrou")

    println("A divisão de $num por $pontoFlutuante é ${num / pontoFlutuante}")

    val numero = 1
    val numero1 = 2
    if (numero != numero1) {
        println("verdade")
    } else {
        println("mentira")
    }

    val carro = true
    val moto = false
    var caminhao = true
    if (carro && moto) {
        println("verdade")
    } else {
        println("falso")
    }

    // v && v v          v || v v      v xor v f
    // v && f f          v || f v      v xor f v
    // f && v f          f || v v      f xor v v
    // f && f f          f || f f      f xor f f

    caminhao = false

    if (!caminhao) {
        println(caminhao)
    } else {
        println("falso")
    }

    //0    1  2  3   4
    val listaDeNumero = arrayListOf("Teste", 2, 4, 5, 5.0)
//    println(listaDeNumero.size)
//    println(listaDeNumero.first())
//    println(listaDeNumero[0])
//    println(listaDeNumero[4])
//    println(listaDeNumero[3])

//    listaDeNumero.add("Teste")
//    listaDeNumero.removeAll(arrayListOf("Teste", 2, 4, 6.0))

    listaDeNumero.forEach { item ->
        if (item == 4) {
            println("Existe o numero 4")
        }
    }

    if (listaDeNumero.contains(4)) {
        println("Existe o numero 4")
    }

    val numeros = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
    val listaFiltrada = numeros.filter {
        it % 2 != 0
    }

    println(listaFiltrada)

    val listaNaoMutavel = listOf("Teste", 1, 3.0)

    listaNaoMutavel[2]
    listaNaoMutavel.get(2)

    //println(listaDeNumero)

    //0 até o n-1

    val altura = 1.90

    when {
        altura < 1.20 -> {
            println("baixa")
        }
        altura <= 1.50 -> {
            println("médio")
        }
        altura <= 1.80 -> {
            println("alta")
        }
        altura != 1.90 -> {
            println("diferente de 1.90")
        }
        else -> {
            println("muito alta")
        }
    }


//    if (altura < 1.20) {
//        println("baixa")
//    } else if (altura <= 1.50) {
//        println("médio")
//    } else if (altura <= 1.80) {
//        println("alta")
//    } else {
//        println("muito alta")
//    }
}


