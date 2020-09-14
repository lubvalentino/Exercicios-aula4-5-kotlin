fun main () {
    var atleta1 = Atleta ("Luciana", 9,6)
    var atleta2 = Atleta ("João", 3,9)

    var prova1 = Prova (10,3)
    var prova2 = Prova (2, 5)
    var prova3 = Prova(5,2)

    println(prova1.podeRealizar(atleta1))
    println(prova2.podeRealizar(atleta1))
    println(prova3.podeRealizar(atleta1))
    println(prova1.podeRealizar(atleta2))
    println(prova2.podeRealizar(atleta2))
    println(prova3.podeRealizar(atleta2))
}

class Atleta (var nome: String, var nivel: Int, var energia: Int){

}

class Prova (var dificuldade: Int, var energiaNecessaria: Int) {
    fun podeRealizar(atleta: Atleta): Boolean {
        return (atleta.nivel >= dificuldade) && (atleta.energia >= energiaNecessaria)
    }
}
