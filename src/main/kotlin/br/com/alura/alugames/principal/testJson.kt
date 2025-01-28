package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main(){
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    var listaJogoJson = consumo.buscaJogosJson()

    var gamerCarol = listaGamers.get(3)
    var jogoResidenteVillage = listaJogoJson.get(10)
    var jogoSpider = listaJogoJson.get(13)
    var jogo = listaJogoJson.get(2)

    var periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    var periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    var periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))



    gamerCarol.alugaJogo(jogoResidenteVillage, periodo1)
    gamerCarol.alugaJogo(jogoSpider, periodo2)
    gamerCarol.alugaJogo(jogo, periodo3)

    println(gamerCarol.jogosAlugados)
}
