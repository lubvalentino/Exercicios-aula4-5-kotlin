fun main () {
    var tripe = Tripe (true, 0.5,1.5,1.0)

    println(tripe.definirAltura(1.4))
    println(tripe.dobrar())
    println(tripe.desdobrar())
    tripe.guardar()
    tripe.prontoParaGuardar()
    tripe.usar()
    println("Posso usar? ${tripe.prontoParaUsar()}")

}

class Tripe (var dobrado: Boolean, var alturaMin : Double, var alturaMax : Double, var alturaAtual: Double){

    fun definirAltura (novaAltura : Double) : Double{
        alturaAtual = novaAltura
        return alturaAtual
    }

    fun dobrar () : Boolean {
        dobrado = true
        return dobrado
    }

    fun desdobrar() : Boolean {
        dobrado = false
        return dobrado

    }

    fun guardar (){
        dobrado = true
        alturaAtual = alturaMin
        println ("Pronto para guardar, dobrado: ${dobrado}, altura atual: ${alturaAtual}")
    }

    fun prontoParaGuardar() {
        if((dobrado && alturaAtual == alturaMin)){
            println("Pode guardar")
        } else {
            println("Executar a função guardar")
        }
    }

    fun usar () {
        !dobrado
        alturaAtual == (alturaMax/2)
        println("Pronto para usar")
    }

    fun prontoParaUsar () : Boolean {
        return (!dobrado && alturaAtual > (alturaMax/2))
    }
}