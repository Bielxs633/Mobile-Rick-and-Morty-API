package br.senai.sp.jandira.rickandmorty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.rickandmorty.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Rick And Morty Background",
            contentScale = ContentScale.Crop
        )
    }


}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}