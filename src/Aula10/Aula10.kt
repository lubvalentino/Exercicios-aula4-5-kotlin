package Aula10

//fun main() {
//
//    val cesar = Pessoa("Cesar", 25)
//    val cesar1 = Pessoa("Cesar", 25)
//
//    //println(cesar)
//    //println(cesar1)
//
//    println(cesar == cesar1)
//
//}
//
//class Pessoa (val nome: String, val idade: Int) {
//
//    override fun equals(other: Any?): Boolean {
//        return other?.let {
//            val pessoa = (it as? Pessoa)
//            pessoa?.let {
//                it.nome == nome && it.idade == idade
//            } ?: false
//        } ?: false
//    }
//
//    override fun hashCode(): Int {
//        return 2
//    }
//
//    override fun toString(): String {
//        return "Meu nome é $nome é minha idade é $idade"
//    }
//}
//
//data class Animal (val nome: String, val tipo: String)