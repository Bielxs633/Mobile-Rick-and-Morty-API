package br.senai.sp.jandira.rickandmorty.service

import br.senai.sp.jandira.rickandmorty.model.Character
import br.senai.sp.jandira.rickandmorty.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Path
import retrofit2.http.Body

interface CharacterService {

    @GET("character")
    fun listAllCharacters(): Call<Result>

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Int): Call<Character>

    // Inserir
    @POST("character")
    fun insert(@Body character: Character): Call<Character>

    // Deletar
    @DELETE("character/{id}")
    fun deleteCharacterById(@Path("id") id: Int): Call<Character>

    // Atualizar
    @PUT("character/{id}")
    fun putCharacterById(@Path("id") id: Int): Call<Character>

}