package Desafios

import java.time.LocalDate
import java.time.Period




class Aluno(var nome: String,var sobrenome: String, var codigoAluno: Int)

open class Professor (val nome: String, val sobrenome: String, val dataContratacao:LocalDate, var codigoProfessor: Int?){
    var tempoDeCasa = Period.between(dataContratacao, LocalDate.now()).toTotalMonths()
}


class ProfessorTitular (especialidade: String, nome: String, sobrenome: String, dataContratacao: LocalDate,
                        codigoProfessor: Int?) : Professor (nome,sobrenome, dataContratacao, codigoProfessor)

class ProfessorAdjunto (var qtdadeHorasMonitoria:Int, nome: String, sobrenome: String, dataContratacao: LocalDate,
                        codigoProfessor: Int?) : Professor (nome,sobrenome, dataContratacao, codigoProfessor)

class Curso (var nomeCurso: String, var codigoCurso: Int, val qtdadeMaxAlunos: Int, var professorTitular: Professor?, var professorAdjunto: Professor?) {
    var listaAlunosMatriculados = mutableListOf<Aluno>()
    fun adicionarUmAluno (): Boolean {
        when {
            listaAlunosMatriculados.size < qtdadeMaxAlunos -> {
                return true
            }
            else -> return false
        }
    }

    fun excluirAluno (umaluno: Aluno?){
        if (listaAlunosMatriculados.contains(umaluno)){
        listaAlunosMatriculados.remove(umaluno)
        println("O aluno ${umaluno?.nome} ${umaluno?.sobrenome} foi removido do curso selecionado") }
        else {
            println("Esse código de aluno não consta na lista de alunos")
        }
    }
}

 class Matricula (aluno: Aluno, curso: Curso ){
     var dataMatricula: LocalDate? = LocalDate.now()
}

class DigitalHouseManager {
    var listaDeAlunos = mutableListOf<Aluno>()
    var listaDeProfessores: MutableList<Professor> = mutableListOf()
    var listaDeCursos: MutableList<Curso> = mutableListOf()
    var teste = false

    fun registrarCurso(nomeCurso: String, codigoCurso: Int, qtdadeMaxAlunos: Int){
        val umcurso = Curso (nomeCurso, codigoCurso, qtdadeMaxAlunos, null, null)
        if (umcurso.qtdadeMaxAlunos > 0){
        listaDeCursos.add(umcurso)
        println("O curso ${umcurso.nomeCurso} foi registrado na lista de cursos")}
        else {
            println("Curso não registrado pois a quantidade máxima de aluno deve ser no mínimo 1")}
    }
    fun excluirCurso (codigoCurso: Int) {
        listaDeCursos.forEach {
            if (it.codigoCurso == codigoCurso){
                if (it.listaAlunosMatriculados.isEmpty()){
                    listaDeCursos.remove(it)
                    println("O curso ${it.nomeCurso} foi removido da lista de cursos")
                return}
                else{
                    println("Este curso não pode ser removido, pois tem alunos matriculados")

            return}}
            else{teste = false}
            }
        if (teste == false){println("O curso não existe")}
        }

    fun registrarProfessorAdjunto (nome: String, sobrenome: String, codigoProfessor: Int){
        val novoProfAdjunto = ProfessorAdjunto (qtdadeHorasMonitoria = 0, nome, sobrenome, dataContratacao = LocalDate.now(), codigoProfessor)
        listaDeProfessores.add(novoProfAdjunto)
        println("O professor ${novoProfAdjunto.nome} ${novoProfAdjunto.sobrenome} foi adicionado a lista de professores como professor adjunto")
    }

    fun registrarProfessorTitular (nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String){
        val novoProfTitular = ProfessorTitular (especialidade, nome, sobrenome, dataContratacao = LocalDate.now(), codigoProfessor)
        listaDeProfessores.add(novoProfTitular)
        println("O professor ${novoProfTitular.nome} ${novoProfTitular.sobrenome} foi adicionado a lista de professores como professor titular")
    }

    fun excluirProfessor (codigoProfessor: Int) {
        listaDeProfessores.forEach {professor: Professor ->
            if (professor.codigoProfessor == codigoProfessor) {
                listaDeCursos.forEach {
                    if (it.professorAdjunto?.codigoProfessor == codigoProfessor || it.professorTitular?.codigoProfessor == codigoProfessor) {
                        println("O professor ${professor.nome} ${professor.sobrenome} não pode ser excluído pois está alocado no curso ${it.nomeCurso}")
                        return
                    } else {
                        listaDeProfessores.remove(professor)
                        println("O professor ${professor.nome} ${professor.sobrenome} foi removido da lista de professores")
                        return}
                }}
                else{ teste = false }
        }
        if (teste == false) {
            println("O professor não foi encontrado na lista")
        }
    }

    fun matricularAluno (nome: String, sobrenome: String, codigoAluno: Int){
        val novoAluno = Aluno(nome, sobrenome, codigoAluno)
        listaDeAlunos.add(novoAluno)
        println("O aluno ${novoAluno.nome} ${novoAluno.sobrenome} foi matriculado")
    }

    fun matricularAlunoCurso(codigoAluno: Int, codigoCurso: Int){
        val listaDeMatriculas : MutableList<Matricula> = mutableListOf()
        listaDeAlunos.forEach {novaMatricula : Aluno ->
            if (novaMatricula.codigoAluno == codigoAluno){
                listaDeCursos.forEach {curso: Curso ->
                    when{
                        (curso.codigoCurso == codigoCurso && curso.adicionarUmAluno()) ->
                            curso.listaAlunosMatriculados.add(novaMatricula). also { println("Matricula foi realizada")
                            listaDeMatriculas.add(Matricula(novaMatricula, curso))}
                        (curso.codigoCurso == codigoCurso && !curso.adicionarUmAluno()) -> println("Não foi possível realizar a matrícula porque não há vagas")}
                    }
            }
        }
    }

    fun alocarProfessores (codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        var professorAdjunto: Professor? = null
        var professorTitular: Professor? = null


        listaDeCursos.forEach{ curso: Curso->
            if (codigoCurso == curso.codigoCurso){
                println("curso encontrado")
                listaDeProfessores.find {
                    codigoProfessorAdjunto == it.codigoProfessor
                }?.let {
                    println("O professor adjunto ${it.nome} ${it.sobrenome} foi alocado no curso ${curso.nomeCurso}")
                    curso.professorAdjunto = it
                } ?: println("O professor não consta na lista de professores, o curso ${curso.nomeCurso} está sem professor adjunto")
                listaDeProfessores.find {
                    codigoProfessorTitular == it.codigoProfessor
                }?.let {
                    println("O professor titular ${it.nome} ${it.sobrenome} foi alocado no curso ${curso.nomeCurso}")
                    curso.professorTitular = it
                } ?: println("O professor não consta na lista de professores, o curso ${curso.nomeCurso} está sem professor titular")
            } else{println("curso não encontrado")}
            }}

    fun exluirAluno(codigoCurso: Int, codigoAluno: Int){
        var umaluno : Aluno? = null
       listaDeAlunos.find {
           it.codigoAluno == codigoAluno
       } ?.let {
           umaluno = it
       }
       listaDeCursos.find {
           codigoCurso == it.codigoCurso
       }?.let {
           it.excluirAluno(umaluno)
       }?: println("Código do curso não existe")
    }
}


 fun main() {

     val professorTitular1 = ProfessorTitular("Kotlin", "Paulo", "Silva", LocalDate.of(2015, 1, 20), 23)
     val professorAdjunto1 = ProfessorAdjunto(20, "Aparecida", "Souza", LocalDate.of(2019, 10, 20), 156)

     val gerenciamento = DigitalHouseManager()

     gerenciamento.matricularAluno("Luciana", "Valentino", 1)
     gerenciamento.matricularAluno("Thatiana", "Valentino", 2)
     gerenciamento.matricularAluno("Aron", "Barros", 3)
     gerenciamento.matricularAluno("Laert", "Barros", 4)
     println()
     println("A lista de alunos matriculados é:")
     gerenciamento.listaDeAlunos.forEach {
         print(it.codigoAluno)
         println(" - ${it.nome} ${it.sobrenome}")}
     println()
     gerenciamento.registrarCurso("Santander Mobile Coder", 10,2)
     gerenciamento.registrarCurso("Matematica", 20,5)
     println()
     println("Os cursos que oferecemos são:")
     gerenciamento.listaDeCursos.forEach {
         println("${it.codigoCurso} - ${it.nomeCurso}")
     }
     println()
     gerenciamento.excluirCurso(20)
     gerenciamento.excluirCurso(30)
     println()
     gerenciamento.registrarProfessorAdjunto("Maria", "Souza",154)
     gerenciamento.registrarProfessorTitular("João", "Silva", 22,"Kotlin")
     gerenciamento.registrarProfessorTitular("Ana", "Silva", 25,"Kotlin")
     println()
     gerenciamento.listaDeProfessores.addAll(listOf(professorAdjunto1, professorTitular1))
     println("Os professores registrados são:")
     gerenciamento.listaDeProfessores.forEach {
         println("${it.codigoProfessor} - ${it.nome} ${it.sobrenome} com ${it.tempoDeCasa} meses de casa")}
     println()
     gerenciamento.excluirProfessor(25)
     gerenciamento.excluirProfessor(100)
     println()
     gerenciamento.matricularAlunoCurso(1, 10)
     gerenciamento.matricularAlunoCurso(2,10)
     gerenciamento.matricularAlunoCurso(3,10)
     println()
     gerenciamento.listaDeCursos.forEach {
         println("A lista de alunos matriculados no curso ${it.nomeCurso}:")
         it.listaAlunosMatriculados.forEach {
             println("${it.codigoAluno} - ${it.nome} ${it.sobrenome}")
         }
     }
     println()
     gerenciamento.excluirCurso(10)
     println()
     gerenciamento.alocarProfessores(10,22,154)
     println()
     gerenciamento.listaDeCursos.forEach {
         println("Código curso: ${it.codigoCurso} - curso: ${it.nomeCurso} - professor titular: ${it.professorTitular?.nome} ${it.professorTitular?.sobrenome}" +
                 " - professor adjunto: ${it.professorAdjunto?.nome} ${it.professorAdjunto?.sobrenome} - número máximo de alunos: ${it.qtdadeMaxAlunos}")
     }
     println()
     try {
         println("O professor adjunto do curso é ${gerenciamento.listaDeCursos.get(gerenciamento.listaDeCursos.filter {
                 it . codigoCurso == 10}.lastIndex).professorAdjunto?.nome}")
     }catch (exception: IndexOutOfBoundsException){println("Não existe este código de curso")}
     println()
    try {println(gerenciamento.listaDeCursos.get(5).professorTitular?.nome)
    } catch (exception: IndexOutOfBoundsException) {
        println("Não existe este índice na lista de cursos")}
     println()
     gerenciamento.exluirAluno(10,2)
 }

