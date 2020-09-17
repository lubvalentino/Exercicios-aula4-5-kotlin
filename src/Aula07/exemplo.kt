package Aula07
fun main(){
    var itemvenda1 = ItemVenda ("calça", 2,5.0)
    var itemvenda2 = ItemVenda ("blusa", 5,10.0)
    var itemServico1 = Servico ("consertar",3,6.0)
    var itemServico2 = Servico ("lavar", 4,12.0)
    val registro = RegistroRecebimentos ()

    println(registro.adicionarRecebimento(itemServico1))
    println(registro.adicionarRecebimento(itemServico2))
    println(registro.adicionarRecebimento(itemvenda1))
    println(registro.adicionarRecebimento(itemvenda2))
    println(registro.apresentarRecebimento())

}

interface IRecebivel {
    fun totalizarReceita () : Double

    fun tooString():String
}

class ItemVenda (val produto: String, val quantidade: Int, val valor: Double) : IRecebivel {
    var valorVenda = 0.0

    override fun totalizarReceita(): Double {
        valorVenda = quantidade*valor
        return valorVenda
    }

    override fun tooString(): String {
        return "A compra de ${quantidade} unidades de ${produto} no valor de R$ ${valor} foi concluída, resultando em R$ ${valorVenda}"
    }

    }
class Servico (val descricao : String, val horas: Int, val precoHora: Double) : IRecebivel {
    var valorServico = 0.0
    override fun totalizarReceita(): Double {
        valorServico = horas*precoHora
        return valorServico
    }

    override fun tooString(): String {
        return "O serviço ${descricao} realizado em ${horas} horas por R$ ${precoHora}/hora foi concluído, resultando em R$ ${valorServico}"
    }


}

class RegistroRecebimentos {
    var total = 0.0
    val listaDeProdutos: MutableList<IRecebivel> = mutableListOf()

    fun registroRecebimentos (){
        total = 0.0
        listaDeProdutos.forEach{
            total += it.totalizarReceita()

        }

    }
    fun adicionarRecebimento (item: IRecebivel) {
        listaDeProdutos.add(item)
        registroRecebimentos()
        when {
            item is ItemVenda -> println(item.tooString())
            item is Servico -> println(item.tooString())
        }
    }

    fun apresentarRecebimento(){
        registroRecebimentos()
        println("Valor total de recebimentos é R$ ${total}")

    }
}
