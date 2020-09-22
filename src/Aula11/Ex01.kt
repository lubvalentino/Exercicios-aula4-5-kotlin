package Aula11

fun main(){
    var animal : ArrayList<String> = arrayListOf()
    animal = arrayListOf("Pato", "Cachorro", "Gato")

    try {
    println(animal.get(3))
    } catch (exception: IndexOutOfBoundsException){
        println("Não foi possível imprimir está posição devido ao erro")
        println(exception.stackTraceToString())
    }
    }
