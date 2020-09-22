package Aula11

class CalculoMatematico {
    @Throws(ArithmeticException::class)
    fun divisao (num1: Int, num2: Int):Int {

        if (num2 == 0) {
            throw ArithmeticException("Não é possível fazer divisão por zero")
        } else {
            return num1 / num2
        }
//        try {
//            num1/num2
//        }catch (exception: ArithmeticException){
//            print("Não foi possível realizar a divisão, o resultado é ")
//        } finally {
//            return 0
//        }
    }
}

fun main(){
    val calculaMatematico = CalculoMatematico ()

//    println(calculaMatematico.divisao(4,0))
    try {
        println(calculaMatematico.divisao(4,0))
    }catch (exception: ArithmeticException){
        println(exception.message)
    }
}