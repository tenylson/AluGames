package br.com.alura.alugames.utilitario

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.InfoGamesJson

fun InfoGamesJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email,this.dataNascimento, this.usuario)
}
