package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    var listaJogoJson = consumo.buscaJogosJson()

    var gamerCarol = listaGamers.get(3)
    var jogoResidenteVillage = listaJogoJson.get(10)

    var alugel = gamerCarol.alogaJogo(jogoResidenteVillage)

    println(alugel)
}
