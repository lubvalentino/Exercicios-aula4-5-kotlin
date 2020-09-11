fun main (){
    var nomeCliente = Cliente2("Luciana", "Valentino")
    var numeroConta = Conta2(12345, 1000.00,nomeCliente)
    var saldoConta = 0.0

    saldoConta = numeroConta.deposito(0.00)
    println("Depósito feito, saldo da conta é $saldoConta")

    numeroConta.saldoAtual = saldoConta

    if (numeroConta.saque(500.00) == numeroConta.saldoAtual) {
        saldoConta = numeroConta.saque(500.00)
        println("Saldo insuficiente, saldo da conta é $saldoConta")
    } else{

        saldoConta = numeroConta.saque(500.00)
        println("Saque feito, saldo da conta é $saldoConta")}


}

class Cliente2 (nome: String, sobrenome: String){

    var firstName = nome
    var lastName = sobrenome

}

class Conta2 (numConta: Int, saldo: Double, titular: Cliente2) {

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
