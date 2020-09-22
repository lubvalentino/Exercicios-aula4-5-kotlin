package Aula10

//grupo02: vanessa fischer, vinicios Alves

class Pessoas (var nome: String, var numRG: String){
    override fun equals(other: Any?): Boolean {
        return other?.let {
            (it as? Pessoas)?.let {
                it.numRG == numRG
            } ?: false
        } ?: false
    }

    override fun hashCode(): Int {
        return 2
    }

}

fun main(){
    var pessoa1 = Pessoas ("Maria", "12345")
    var pessoa2 = Pessoas ("Maria", "12345")

    print(pessoa1 == pessoa2)
}