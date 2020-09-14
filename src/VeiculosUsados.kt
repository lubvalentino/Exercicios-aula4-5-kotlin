fun main(){
    var cliente = Clientes ("Luciana", "Valentino", "1234-5678")
    var carro = Carros ("Citroen", "C3",2014, "Preto", 20000)
    var venda = Venda(cliente, carro,30000.00)
    var concessionaria = Concessionaria ()

    concessionaria.registrarVeiculo(carro,cliente,venda.valorVenda)
    println("O cliente ${cliente.nome} comprou o carro ${carro.marca} por R$ ${venda.valorVenda}")

}

class Carros (var marca: String, var modelo: String, var anoFabricacao : Int, var cor : String, var quilometragem: Int){

}

class Clientes (var nome: String, var sobrenome: String, var telefone: String){

}

class Concessionaria (){
    fun registrarVeiculo (carro: Carros, cliente: Clientes, valorVenda:Double){

    }

}

class Venda(var cliente : Clientes, var carro: Carros, var valorVenda: Double){
    }