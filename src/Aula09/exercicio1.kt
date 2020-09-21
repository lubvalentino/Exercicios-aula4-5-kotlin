package Aula09

//fabio molinari, jonatas araujo, vinicios alves
fun main (){
    val exercicio1 = Exercicio1 ()
    exercicio1.loteria()
    exercicio1.apelidos()
}
    val loteria = mutableMapOf<Int,String>(
            0 to "ovos",
            1 to "Água",
            2 to "Escopeta",
            3 to "Cavalo",
            4 to "Dentista",
            5 to "Fogo")

    val apelidos = mapOf<String,String>(
            "João" to "Juan, Fissura, Maromba",
            "Miguel" to "Night Watch, Bruce Wayne, Tampinha",
            "Maria" to "Wonder Woman, Mary, MArilene",
            "Lucas" to "Lukinha, Jorge, George"
    )

class Exercicio1{
    fun loteria () {
        loteria.forEach {
            println(it)
        }
    }

    fun apelidos (){
        apelidos.forEach {
            println(it)
        }
    }
}


