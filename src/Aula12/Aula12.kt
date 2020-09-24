package Aula12

import java.util.*

//dupla 5
fun main() {
    val livro1 = Livro(12, "aaa", "aaa", 2020,
            100.0, 50.0,"alugado")
    val livro2 = Livro(123, "bbb", "bb", 2020,
            100.0, 50.0,"alugado")
    val livro3 = Livro(124, "ccc", "ccc", 2020,
            100.0, 50.0,"alugado")
    val livraria = LivrariaBiblioteca("Central", "1920")


    livraria.cadastrarLivros(livro1)
//    println(livraria.listaLivros[0].codigo)
    livraria.cadastrarColecao(mutableListOf(livro1, livro2, livro3))
//    println(livraria.colecao[0])
    livraria.consultarLC(12)
}


class LivrariaBiblioteca (nome: String, dataCriacao: String){
    val listaLivros: MutableList<Livro> = mutableListOf()
    var i = 0
    val colecao: MutableMap<Int,List<Livro>> = mutableMapOf()
    fun cadastrarLivros(livro: Livro){
        listaLivros.add(livro)
    }

    fun cadastrarColecao (listaColecao: MutableList<Livro>){
        colecao.put(i,listaColecao)
        i++
    }

    fun consultarLC (consulta: Int){
        var teste: Boolean = false
        listaLivros.forEach {
            if (it.codigo == consulta) {println("${it.codigo}, ${it.autor}, ${it.titulo}")
                return@forEach}
            else{teste=false}
        }
        colecao.forEach {
            it.value.forEach {
            if (it.codigo == consulta) {println("${it.codigo}, ${it.autor}, ${it.titulo}")
                return}
            else{teste=false}
        }}
        if (teste == false){
           println("Livro/coleção não encontrado")}

        fun consultarLC (consulta: String){
            var teste: Boolean = false
            listaLivros.forEach {
                if (it.titulo == consulta) {println("${it.codigo}, ${it.autor}, ${it.titulo}")
                    return@forEach}
                else{teste=false}
            }
            colecao.forEach {
                it.value.forEach {
                    if (it.titulo == consulta) {println("${it.codigo}, ${it.autor}, ${it.titulo}")
                        return}
                    else{teste=false}
                }}
            if (teste == false){
                println("Livro/coleção não encontrado")}

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
                    "disponível" -> {d++}
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
}

open class Livro (var codigo: Int, var titulo: String, var autor: String, var anoLancamento: Int,
             var precoVenda: Double, var precoAluguel: Double,var estadoAtual: String){

}

class Cliente(nome:String, rg: String,
              historicoAlugueisCompras: MutableMap<Int,List<String>>){

}

class Funcionario (nome:String, rg:String,
                   historicoAlugueisVendas: MutableMap<Int,List<String>>){

}
