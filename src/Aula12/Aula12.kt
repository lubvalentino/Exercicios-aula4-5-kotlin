package Aula12

import java.util.*

//dupla 5 : Bruno Bello
fun main() {
    val livro1 = Livro(12, "aaa", "aaa", 2020,
            100.0, 50.0,"disponivel")
    val livro2 = Livro(123, "bbb", "bb", 2020,
            100.0, 50.0,"disponivel")
    val livro3 = Livro(124, "ccc", "ccc", 2020,
            100.0, 50.0,"disponivel")
    val livraria = LivrariaBiblioteca("Central", "02/02/1920")


    livraria.cadastrarLivros(livro1)
    livraria.cadastrarLivros(livro2)
    livraria.cadastrarLivros(livro3)
    livraria.cadastrarColecao(mutableListOf(livro1))
    livraria.cadastrarColecao(mutableListOf(livro2, livro3))
    livraria.consultarLC(123)
    livraria.consultarLC(2)
    livraria.consultarLC("ccc")
    livraria.consultarLC("ddd")
    livraria.alugarLC(123)
    livraria.alugarLC(123)
    livraria.efetuarVenda(124)
    livraria.efetuarVenda(123)
    livraria.efetuarVenda(12)
    livraria.verificarEstoque()
}


class LivrariaBiblioteca (nome: String, dataCriacao: String){
    val listaLivros: MutableList<Livro> = mutableListOf()
    var i = 0
    val colecao: MutableMap<Int,List<Livro>> = mutableMapOf()
    fun cadastrarLivros(livro: Livro){
        listaLivros.add(livro)
        println("O livro ${livro.titulo} do autor ${livro.autor} foi cadastrado com o código ${livro.codigo}")
    }

    fun cadastrarColecao (listaColecao: MutableList<Livro>){
        colecao.put(i,listaColecao)
        println("A coleção $i foi cadastrada com a lista de livros ${colecao.values}")
        i++
    }

    fun consultarLC (consulta: Any){
        if(consulta is Int){
        var teste = false

        listaLivros.forEach {
            if (it.codigo == consulta) {println("O livro ${it.titulo} com o código ${it.codigo} do autor ${it.autor} foi encontrado e está ${it.estadoAtual}")
                return@forEach}
            else{teste=false}
        }
        colecao.forEach {
            it.value.forEach {
            if (it.codigo == consulta) {println("O livro ${it.titulo} com o código ${it.codigo} que está na coleção ${colecao.keys} foi encontrado")
                return}
            else{teste=false}
        }}
        if (teste == false){
           println("Livro/coleção não encontrado pelo código")}}

        if(consulta is String){
            var teste = false
            listaLivros.forEach {
                if (it.titulo == consulta) {println("O livro ${it.titulo} com o código ${it.codigo} do autor ${it.autor} foi encontrado e está ${it.estadoAtual}")
                    return@forEach}
                else{teste=false}
            }
            colecao.forEach {
                it.value.forEach {
                    if (it.titulo == consulta) {println("O livro ${it.titulo} com o código ${it.codigo} que está na coleção ${colecao.keys} foi encontrado")
                        return}
                    else{teste=false}
                }}
            if (teste == false){
                println("Livro/coleção não encontrado pelo título")}}

    }
        fun alugarLC (livreAl: Int){
            listaLivros.forEach {
                if (it.codigo == livreAl) {
                    if(it.estadoAtual == "alugado" || it.estadoAtual == "vendido"){
                        println("Livro não disponível")
                        return} else{it.estadoAtual = "alugado"
                    println("Você alugou o livro ${it.titulo}")}
                    }
                }
        }

        fun efetuarVenda(venda: Int){
            listaLivros.forEach {
                if (it.codigo == venda) {
                    if(it.estadoAtual == "alugado" || it.estadoAtual == "vendido"){
                        println("Livro não disponível")
                        return} else{it.estadoAtual = "vendido"
                        println("Você comprou o livro ${it.titulo}") }
                }
            }
        }

        fun verificarEstoque (){
            var d = 0
            var a = 0
            var v = 0
            var valorVendaTotal = 0.0
            listaLivros.forEach {
                when (it.estadoAtual) {
                    "disponivel" -> {d++}
                    "alugado" -> {a++}
                    else -> {v++
                    valorVendaTotal+=it.precoVenda}
                }
            }
            println("Valor da venda total é $valorVendaTotal")
            println("Número de livros disponíveis é $d")
            println("Número de livros alugados é $a")
            println("Número de livros vendidos é $v")
        }
}

open class Livro (var codigo: Int, var titulo: String, var autor: String, var anoLancamento: Int,
             var precoVenda: Double, var precoAluguel: Double,var estadoAtual: String){

}

class Cliente(nome:String, rg: String,
              historicoAlugueis: MutableList<Livro>, historicoCompras: MutableList<Livro>){

}

class Funcionario (nome:String, rg:String,
                   historicoAlugueis:MutableList<Livro>,
                   historicoVendas: MutableList<Livro>){

}
