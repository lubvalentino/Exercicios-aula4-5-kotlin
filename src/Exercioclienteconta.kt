//fun main (){
  //  var nomeCliente = Cliente("Luciana", "Valentino")
  //  var numeroConta = Conta(12345, 1000.00,nomeCliente)
  //  var saldoConta = 0.0

  //  saldoConta = numeroConta.deposito(0.00)
  //  println("Depósito feito, saldo da conta é $saldoConta")

  //  numeroConta.saldoAtual = saldoConta

   // if (numeroConta.saque(500.00) == numeroConta.saldoAtual) {
    //    saldoConta = numeroConta.saque(500.00)
      //  println("Saldo insuficiente, saldo da conta é $saldoConta")
   // } else{

    //saldoConta = numeroConta.saque(500.00)
    //println("Saque feito, saldo da conta é $saldoConta")}
//}

class Cliente (nome: String, sobrenome: String){

    var firstName = nome
    var lastName = sobrenome

}

class Conta (numConta: Int, saldo: Double, titular: Cliente) {

    var conta = numConta
    var saldoAtual = saldo
    var cliente = titular


    fun deposito(dinheiro: Double): Double {
        var saldoFinal = saldoAtual +dinheiro
        return saldoFinal
    }

    fun saque (retiradaDinheiro: Double): Double {
        var saldoDia = saldoAtual

       if (saldoDia >= retiradaDinheiro){
            saldoDia -= retiradaDinheiro
           return saldoDia
        } else {
            return saldoDia
        }
    }
}

class Exercicio1 (titularConta: Cliente, contaTitular: Conta){
    
    var customer = titularConta
    var cont = contaTitular
    var saldoExercicio1 = contaTitular.saldoAtual

    fun deposito(dinheiro: Double): Double {
        var saldoFinal = saldoExercicio1 +dinheiro
        return saldoFinal
    }

    fun saque (retiradaDinheiro: Double): Double {
        var saldoDia = saldoExercicio1

        if (saldoDia >= retiradaDinheiro){
            saldoDia -= retiradaDinheiro
            return saldoDia
        } else {
            return saldoDia
        }
    }
}


fun main (){
    var cliente1 = Exercicio1(Cliente("Luciana", "Valentino"),Conta(12345,100.00,Cliente("Luciana", "Valentino")))
    var cliente2 = Exercicio1(Cliente("Thatiana", "Valentino"), Conta(45678,2000.00,Cliente("Thatiana", "Valentino")))
    var saldoDaConta1 = 0.0
    var saldoDaConta2 = 0.0
    
    saldoDaConta1 = cliente1.deposito(0.00)
        println("Depósito feito, saldo da conta do cliente 1 é $saldoDaConta1")

    cliente1.saldoExercicio1 = saldoDaConta1

    if (cliente1.saque(500.00) == cliente1.saldoExercicio1) {
        saldoDaConta1 = cliente1.saque(500.00)
        println("Saldo insuficiente, saldo da conta do cliente 1 é $saldoDaConta1")
    } else{

        saldoDaConta1 = cliente1.saque(500.00)
        println("Saque feito, saldo da conta do cliente 1 é $saldoDaConta2")}


    saldoDaConta2 = cliente2.deposito(0.00)
    println("Depósito feito, saldo da conta do cliente 2 é $saldoDaConta2")

    cliente2.saldoExercicio1 = saldoDaConta2

    if (cliente2.saque(500.00) == cliente2.saldoExercicio1) {
        saldoDaConta2 = cliente2.saque(500.00)
        println("Saldo insuficiente, saldo da conta do cliente 2 é $saldoDaConta2")
    } else{

        saldoDaConta2 = cliente2.saque(500.00)
        println("Saque feito, saldo da conta do cliente 2 é $saldoDaConta2")}

    println("O saldo final do cliente 1 é $saldoDaConta1")
    println("O saldo final do cliente 2 é $saldoDaConta2")
}
        