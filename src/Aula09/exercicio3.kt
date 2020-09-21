package Aula09

class Prova {
    fun somaTotal (conjuntoDeInteiros: Set<Int>): Int{
        return conjuntoDeInteiros.sum()
    }
}
fun main (){
    val teste = Prova()

    println("${teste.somaTotal(setOf(1, 2, 3, 4))}")
}