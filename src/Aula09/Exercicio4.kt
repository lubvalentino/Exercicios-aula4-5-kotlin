package Aula09

abstract class Peca (var marca: String, var modelo: String){
    abstract fun retirada ()
}

class GuardaVolumes {
    var contador = 0
    var guardaVolume = mutableMapOf<Int, List<Peca>>()

    fun guardarPecas (listaDePeca: List<Peca>):Int{
        contador++
        guardaVolume.put(contador,listaDePeca)
        return contador
    }

    fun mostrarPecas (){
        println("A lista de peças que estão no guarda volumes são:")
        guardaVolume.forEach {key, value ->
            println(key)
            value.forEach {
                println("${it.marca} - ${it.modelo}")
            }}

    }

    fun mostrarAPeca(numero: Int) {
        println("As peças do numero $numero são:")
        guardaVolume.getValue(numero).forEach {
            println("${it.marca} - ${it.modelo}")
        }
    }

    fun devolverPecas (numero: Int) {
        if (guardaVolume.containsKey(numero)){
        guardaVolume.remove(numero)
        println("Peças do número $numero foram retiradas pelo dono")}
        else {
            println("Não existe o número $numero no guarda volumes")
        }

    }
}

class Roupas (marca:String, modelo: String ) : Peca (marca, modelo){
    override fun retirada() {
    }
}

fun main (){
    val pecas1 = Roupas ("Adidas", "Camiseta")
    val pecas2 = Roupas("Adidas", "Shorts")
    val pecas3 = Roupas("Nike", "Jaqueta")
    val pecas4 = Roupas ("Nike", "Calça")


    val listaDePecas1 =  listOf(pecas1,pecas2)
    val listaDePeca2 = listOf(pecas3, pecas4)

    val guardaVolumes = GuardaVolumes()

    guardaVolumes.guardarPecas(listaDePecas1)
    guardaVolumes.guardarPecas(listaDePeca2)

    guardaVolumes.mostrarPecas()
    println()
    guardaVolumes.mostrarAPeca(2)
    println()
    guardaVolumes.devolverPecas(2)
    println()
    guardaVolumes.mostrarPecas()

}
