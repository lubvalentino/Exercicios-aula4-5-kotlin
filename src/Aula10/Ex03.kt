package Aula10

class Aluno (var nome:String, var numero: Int){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Aluno

        if (numero != other.numero) return false

        return true
    }

    override fun hashCode(): Int {
        return numero
    }
}


fun main (){
    var listaDeAluno: MutableList<Aluno> = mutableListOf()
    val aluno1 = Aluno ("Luciana", 123)
    val aluno2 = Aluno ("Vanessa", 456)
    val aluno3 = Aluno ("Vinicios", 789)
    val aluno4 = Aluno ("Maria", 159)
    val aluno5 = Aluno ("João", 456)

    listaDeAluno = mutableListOf(aluno1, aluno2, aluno3, aluno4)

    when  {
        (listaDeAluno.contains(aluno5)) -> println("Este número já está sendo usado, usar outro número para cadastrar o aluno ${aluno5.nome}")
        else -> {
            println("Pode cadastrar o aluno ${aluno5.nome} com o número ${aluno5.numero}")}
    }}