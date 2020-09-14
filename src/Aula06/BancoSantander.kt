package Aula06

fun main (){
    var cliente = Clientes (12, "Valentino","123456", "987654")
    var contaPoup = ContaPoup (1000.00, cliente, 0.10)
    var cheque = Cheque (500.0, "Santander", "14/09/2020")
    var contaCorrente = ContaCorrente(500.0, cliente,cheque)

    println(contaPoup.consultar())
    println(contaPoup.fazerDeposito(100.00))
    println(contaPoup.recolherjuros())
    contaPoup.sacar(2000.00)
    println(contaPoup.consultar())

    println(contaCorrente.consultar())
    println(contaCorrente.depositarCheque())
    println(contaCorrente.fazerDeposito(100.00))
    contaCorrente.sacar(2000.00)
    println(contaCorrente.consultar())

}

class Clientes (var numCliente:Int, var sobrenome: String, var numRg: String, var numCPF: String){

}

open class Conta (var saldo: Double, var nome: Clientes){

    open fun fazerDeposito (dinheiro : Double) : Double{
        saldo += dinheiro
        return saldo
    }

    open fun sacar (dinheiro: Double) {
        saldo -= dinheiro
        println("O saldo é ${saldo}")
    }

    open fun consultar () : Double {
        return saldo
    }
}

class ContaPoup (saldo: Double, nome: Clientes, var txjuros: Double) : Conta(saldo,nome){

    override fun sacar(dinheiro: Double){
        if (dinheiro < saldo){
            saldo -= dinheiro
            println("O saldo é ${saldo}")
        } else{
            println("O saldo é insuficiente para fazer saque, o saldo é ${saldo}")
        }
    }
    fun recolherjuros (): Double{
        saldo *= (1 + txjuros)
        return saldo
    }
}

class Cheque (var valor: Double, bancoEmissor: String, dtPagamento: String){

}

class ContaCorrente (saldo: Double, nome: Clientes, var cheque: Cheque) : Conta (saldo, nome){

    override fun sacar(dinheiro: Double) {
        saldo -= dinheiro
        if (saldo > 0){
            println("O saldo é ${saldo}")
        } else{
            println("Usando cheque especial, o saldo é ${saldo}")
        }}

    fun depositarCheque () : Double {
        saldo += cheque.valor
        return saldo
    }
}
