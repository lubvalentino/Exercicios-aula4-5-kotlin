package Aula06

fun main(){
    var ingresso = Ingresso(100.0)
    var vip = Vip (100.0, 50.0)
    var normal = Normal(100.0)
    var camaroteInferior = CamaroteInferior("Camarote Inferior",100.0,50.0)
    var camaroteSuperior = CamaroteSuperior (100.0,50.0,50.0)

    println(ingresso.imprimeValor())
    println(vip.imprimeValor())
    normal.imprimeIngresso()
    camaroteInferior.camaroteInferior()
    println(camaroteSuperior.imprimeValor())
}
open class Ingresso (var valor: Double) {
    open fun imprimeValor() : Double {
        return valor
    }
}
open class Vip (valor: Double, var valorAdicional: Double) : Ingresso(valor){
    override fun imprimeValor()  : Double {
        valor = super.imprimeValor() + valorAdicional
        return valor
    }
}

class Normal (valor: Double) : Ingresso (valor) {
    fun imprimeIngresso () {
        println ("Ingresso Normal")
    }
}

class CamaroteInferior (var localIngresso: String, valor: Double, valorAdicional: Double) : Vip(valor, valorAdicional) {
    fun camaroteInferior (){
        println("A localização é ${localIngresso}")
    }
}

class CamaroteSuperior (valor: Double, valorAdicional: Double, var valorAdSup: Double) : Vip(valor, valorAdicional) {
    override fun imprimeValor(): Double {
        return super.imprimeValor() + valorAdSup
    }
}