package br.senai.sp.jandira.rickandmorty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.rickandmorty.R
import br.senai.sp.jandira.rickandmorty.model.Character
import br.senai.sp.jandira.rickandmorty.model.Result
import br.senai.sp.jandira.rickandmorty.screens.components.CharacterCard
import br.senai.sp.jandira.rickandmorty.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    // Variavel que vai armazenar a lista de personagens da API:
    var characterList by remember {
        mutableStateOf(listOf<Character>())
    }

    // Fazer uma chamada para a API:
    var call = RetrofitFactory()
        .getCharacterService()
         .listAllCharacters()

    call.enqueue(object : Callback<Result> {
        override fun onResponse(call: Call<Result>, response: Response<Result>) {
            //TODO("Not yet implemented")
            characterList = response.body()!!.results!!
        }

        override fun onFailure(p0: Call<Result>, p1: Throwable) {
            TODO("Not yet implemented")
        }

    })

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.rickandmorty2),
            contentDescription = "Rick And Morty Background",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xaa000000))
        ){

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ){
            Text(
                text = "Rick & Morty",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(14.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = {}){
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Characters",
                fontSize = 24.sp,
                color = Color.White
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                items(characterList){
                    CharacterCard(
                        name = it.name,
                        species = it.species,
                        status = it.status,
                        image = it.image
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}