open class JogadorDeFutebol(nome: String, energia: Int, alegria: Int, gols: Int, experiencia: Int){

    var nomeJogador = nome
    var indEnergia = energia
    var indAlegria = alegria
    var numGols = gols
    var indExperiencia = experiencia


    open fun fazerGol (golFeito: Int): Int {

        if (golFeito ==1){
            indEnergia -= 5
            indAlegria += 10
            numGols += 1
            println("GOOOOL")
            return numGols
        } else{
            return numGols
        }

    }

    open fun correr (): Int {
        indEnergia -= 10
        println("Cansei")
        return indEnergia
    }

}

class SessaDeTreinamento (nome: String, energia: Int, alegria: Int, gols: Int, experiencia: Int) : JogadorDeFutebol (nome, energia, alegria, gols, experiencia){

    override fun correr(): Int {
        return super.correr()
    }

    override fun fazerGol(golFeito: Int): Int {
        return super.fazerGol(golFeito)
    }

    fun treinarA () : Int{
        super.fazerGol(1)
        super.correr()
        indExperiencia += 1
        return indExperiencia
    }
}


fun main(){
    var jogador = JogadorDeFutebol("Ronaldo",30,6,5,7)
    var novaExperiencia = SessaDeTreinamento (jogador.nomeJogador, jogador.indEnergia, jogador.indAlegria, jogador.numGols, jogador.indExperiencia)

    //jogador.fazerGol(1)
   // jogador.correr()
    novaExperiencia.treinarA()

    println("O jogador ${jogador.nomeJogador} está com energia ${jogador.indEnergia}, alegria ${jogador.indAlegria} e ${jogador.numGols} gols e tem experiencia " +
            "${novaExperiencia.indExperiencia}")

}