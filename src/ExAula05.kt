//Exercicio1
fun fatorial (numero: Int) : Int {
    var aux = numero
    var resultado = 1
    while (aux > 0) {
        resultado *= aux
        aux--
    }
    return resultado
}
fun main() {
    //println(fatorial(3))
   // println(exercicioDois(45,15,"M"))
    println(exercicioTres(mutableListOf(1,3,5)))

}

//Exercicio2
fun exercicioDois (idade: Int,anosContribuicao: Int, sexo: String){
    when {
            sexo == "F" && idade >= 60 && anosContribuicao >=30 -> {println (true)}
            sexo == "M" && idade >=65 && anosContribuicao >= 30-> {println(true)}
            else -> println(false)
    }
}

//Exercicio3

fun exercicioTres (list: MutableList <Int>): Int{
    return list.reduce (Int::times)

}