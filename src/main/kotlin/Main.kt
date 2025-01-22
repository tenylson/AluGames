

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

// código omitido


//https://pennyblack.tjro.jus.br/pennyblack/tipo-selo
//https://www.cheapshark.com/api/1.0/games?id=146
fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()


    // código omitido

    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    var json = response.body()

    var gson = Gson()



    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

    val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)

    println(json)
    println(meuJogo)

}