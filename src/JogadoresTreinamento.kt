fun main (){
    var jogador1 = JogadorDeFutebol("Luciana", 80, 60,6, 20)
    val treinar = SessaoDeTreinamento ()
    jogador1.fazerGol()
    jogador1.correr()
    println(jogador1.energia)
    println(jogador1.alegria)
    println(jogador1.gols)
    treinar.treinarA(jogador1)
    jogador1.experiencia

}


open class JogadorDeFutebol(var nome: String, var energia: Int, var alegria: Int, var gols: Int, var experiencia: Int){

    open fun fazerGol() {
        energia -= 5
        alegria += 10
        gols += 1
        println("GOOOLL")
    }
    open fun correr (){
        energia -= 10
        println("Cansei")
    }
    }

class SessaoDeTreinamento  {
    var experiencia = 1

    fun treinarA (jogador: JogadorDeFutebol){      //paramentro de entrada o Jogador de futebol
        println("Experiência inicial é ${jogador.experiencia}")
        jogador.correr()
        jogador.fazerGol()
        jogador.correr()
        jogador.experiencia += experiencia
        print("Experiência inicial é ${jogador.experiencia}")
    }
}