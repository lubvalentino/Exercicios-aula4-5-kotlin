package Aula08

class Estoque (var nome: String, var qtdAtual: Int, var qtdMinima: Int){
    init {
        if (qtdAtual < 0){
            qtdAtual = 0
        }
        if (qtdMinima < 0){
            qtdMinima = 0
        }
    }
    fun mudarNome(nome: String){
        this.nome = nome
        println("O novo nome é $nome")
    }

    fun mudarQtdMinima (qtdMinima: Int): Int {
        return qtdMinima
    }

    fun repor (qtd:Int): Int{
       qtdAtual += qtd
        return qtdAtual
    }

    fun darBaixa (qtd: Int): Int{
        qtdAtual -= qtd
        if (qtdAtual<0){
            qtdAtual = 0
        }else {qtdAtual}
        return qtdAtual
    }

    fun mostrar() : String{
        return "O produto $nome tem quantidade mínima de $qtdMinima e a quantidade atual é de $qtdAtual"
    }

    fun precisaRepor () : Boolean{
        return qtdAtual<=qtdMinima
    }
}

fun main(){
    var estoque1 = Estoque("Parafuso", 15000, 5000)


    estoque1.mudarNome("Parafuso pequeno")
    println("O novo estoque mínimo do ${estoque1.nome} é ${estoque1.mudarQtdMinima(1000)}")
    println("O estoque atual é de ${estoque1.repor(1000)}")
    println("O estoque atual é de ${estoque1.darBaixa(10000)}")
    println(estoque1.mostrar())
    println("${estoque1.precisaRepor()}")
}