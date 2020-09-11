fun main (){

    meunome(nome = "Luciana", sobrenome = "Valentino")
    val resultado = qualNumeroEhMaior(numero1 = 2, numero2 = 7)
    println("O maior número é $resultado")
}

fun meunome(nome: String, sobrenome: String){
    println("Meu nome é $nome $sobrenome")
}

fun qualNumeroEhMaior (numero1: Int, numero2: Int) : Int {
    return if (numero1 > numero2) {
        numero1
    } else {
        numero2
    }
}