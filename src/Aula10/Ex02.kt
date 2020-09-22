package Aula10

class Coca (var tamanho: Int, var preco: Double){

    override fun equals(other: Any?): Boolean {
        return other?.let { it
            (it as? Coca)?.let {
                it.tamanho == tamanho
            }?:false
        }?:false
    }

    override fun hashCode(): Int {
        return 2
    }

}

fun main (){
    val coca1 = Coca(500,3.0)
    val coca2 = Coca (500,5.0)

    println(coca1 == coca2)
}