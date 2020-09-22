package Aula10

class Funcionario (var nome: String, var numeroDeRegistro: Int){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Funcionario

        if (numeroDeRegistro != other.numeroDeRegistro) return false

        return true
    }

    override fun hashCode(): Int {
        return numeroDeRegistro
    }
}

fun main (){
    var listaDeFuncionario : MutableList<Funcionario> = mutableListOf()

    val funcionario1 = Funcionario ("Luciana", 100)
    val funcionario2 = Funcionario ("Vanessa", 97)
    val funcionario3 = Funcionario ("Vinicios", 112)
    val funcionario4 = Funcionario ("João", 55)

    val funcionario5 = Funcionario ("Maria", 100)

    listaDeFuncionario = mutableListOf(funcionario1, funcionario2, funcionario3, funcionario4)

    when{
        (listaDeFuncionario.contains(funcionario5)) -> println("O número de registro ${funcionario5.numeroDeRegistro} já está sendo usadao, cadastrar outro número")
        else ->{
            println("Pode cadastrar o funcionário ${funcionario5.nome} com o número de registro ${funcionario5.numeroDeRegistro}")}
    }
}