package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer

fun main(){
    val gamer1 = Gamer("Pedro Alugames","pedro@gmail.com");
    println(gamer1);

    val gamer2 = Gamer(
        "Ana Laura Ketes Costa",
        "alketes@gmail.com",
        "15/05/2011",
        "maxketes");

    println(gamer2);

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "kackquesskywalker"

    }
    println(gamer1)
    gamer1.also { gamer1.idInterno }

    gamer1.usuario ="teste"

    println(gamer1)
}