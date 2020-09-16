package Aula07

fun main(){
    var foto = Foto("Luciana")
    var documento = Documento ("Estudos")
    var contrato = Contrato ("Locação")
    var impressora = Impressora ()


    impressora.listaImpressora(foto)
    impressora.listaImpressora(documento)
    impressora.listaImpressora(contrato)
    impressora.imprimir()


}

interface Imprimivel{
    var nome : String
    var tipoDeDocumento : String
    fun imprimir() : String
}

class Foto (override var nome: String, override var tipoDeDocumento: String = "Foto") : Imprimivel {
    override fun imprimir(): String {
        return "Eu sou uma selfie - ${nome} - ${tipoDeDocumento}"
    }
}
class Documento (override var nome: String, override var tipoDeDocumento: String = "Documento") : Imprimivel{
    override fun imprimir(): String {
        return "Eu sou um documento word - ${nome} - ${tipoDeDocumento}"
    }
}
class Contrato (override var nome: String, override var tipoDeDocumento: String = "Contrato") : Imprimivel {
    override fun imprimir(): String {
        return "Sou um contrato muito legal - ${nome} - ${tipoDeDocumento}"
    }
}

class Impressora(){
    var listaImprimivel = mutableListOf<String>()
    fun listaImpressora(item:Imprimivel){
        listaImprimivel.add(item.imprimir())
    }
    fun imprimir (){
        for(item in listaImprimivel){
            println(item)
        }
    }
}