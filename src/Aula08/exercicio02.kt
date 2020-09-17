package Aula08

//grupo 9
class Item(val numItem: Int, var descItem: String, var qtddItem: Int, var precoItem: Double) {
    init {
        if(qtddItem<0) {
            qtddItem=0
        }
        if(precoItem<0){
            precoItem=0.0
        }
        println("O item $descItem tem quantidade de $qtddItem e valor unitario de $precoItem. " +
                "O valor total é de ${precoItem*qtddItem}.")
    }
}
class Fatura(){
    var listaItens: MutableList<Item> = mutableListOf()
    fun getTotalFatura(){
        var totalFatura = 0.0
        listaItens.forEach{
            totalFatura+=(it.precoItem*it.qtddItem)
        }
        println("O valor total da fatura é de R$$totalFatura")
    }
}
fun main(){
    val item1 = Item(1,"Teclado",-2,-30.0)
    val item2 = Item(2,"Mouse", 1,10.0)
    var carrinho1 = Fatura()
    carrinho1.listaItens.add(item1)
    carrinho1.listaItens.add(item2)
    carrinho1.getTotalFatura()
}