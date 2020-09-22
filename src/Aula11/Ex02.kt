package Aula11

import java.lang.IndexOutOfBoundsException

fun main () {
    val animal: ArrayList<String?>? = null

    animal?.add("Pato") ?: println("Não foi adicionado")
    animal?.add("Cachorro") ?: println("Não foi adicionado")
    animal?.add("Gato") ?: println("Não foi adicionado")


    try {
        println(animal!!.get(2))

    }catch (exception: NullPointerException){
        println(exception.stackTraceToString())
    }

    val lista: ArrayList<String> = arrayListOf()
    lista.add("Pato")
    lista.add("Cachorro")
    lista.add("Gato")

    try {
        println(lista.get(5))
    }catch (exception: IndexOutOfBoundsException){
        println(exception.stackTraceToString())
    }
}