package Aula09

//grupo 8: roberto, alexandre, mateus menezes
var listaEx2_2 = mutableListOf<Int>()
var listaEx2_3 = mutableSetOf<Int>()

fun main(){
    println("===== Exercício 02 - 03 =====")
    listaEx2_2.addAll(listOf(1,5,5,6,7,8,8,8))
    listaEx2_2.forEach{print(" $it")}
    println()

    println("===== Exercício 02 - 04 =====")
    listaEx2_3.addAll(listOf(1,5,5,6,7,8,8,8))
    listaEx2_3.forEach{print(" $it")}
    println()
}