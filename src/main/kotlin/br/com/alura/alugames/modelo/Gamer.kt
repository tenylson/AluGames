package br.com.alura.alugames.modelo

import java.time.LocalDate
import java.util.Scanner
import kotlin.random.Random


data class Gamer(var nome:String,var email:String){
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value){
            field = value
            if(idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }

    var idInterno:String? = null
        private set

    var jogosBuscados:MutableList<Jogo?> = mutableListOf<Jogo?>()

    var jogosAlugados:MutableList<Aluguel?> = mutableListOf<Aluguel?>()

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo ):Aluguel{
        var alugel = Aluguel(this,jogo, periodo)
        jogosAlugados.add(alugel)
        return alugel
    }

    constructor(nome: String,email: String,dataNascimento:String,usuario:String):this(nome,email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
    }

    init {
        this.nome = validaNome()
        this.email = validarEmail()
    }

    fun validaNome(): String{
        if(nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome esta em branco")
        }
        return this.nome
    }

    fun validarEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)){
            return email
        } else{
            throw IllegalArgumentException("Email inválido")
        }
    }

    companion object{
        fun criarGamer(leitura:Scanner) : Gamer{
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome,email,nascimento, usuario)
            }else{
                return Gamer(nome,email)
            }

        }
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }




}


