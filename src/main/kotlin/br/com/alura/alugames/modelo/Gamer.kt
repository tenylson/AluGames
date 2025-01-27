package br.com.alura.alugames.modelo

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

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }




    var idInterno:String? = null
        private set

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

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }




}


