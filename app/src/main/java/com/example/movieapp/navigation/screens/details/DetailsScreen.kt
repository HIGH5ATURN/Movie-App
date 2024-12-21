package com.example.movieapp.navigation.screens.details
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieID: String?) {

val newMovieList = getMovies().filter { movie ->
        movie.id == movieID
}

        Scaffold(
                topBar = {
                        CenterAlignedTopAppBar(
                                title = { Text("Movies") },
                                colors = TopAppBarDefaults.topAppBarColors(
                                        containerColor = Color(146, 186, 222),
                                        titleContentColor = MaterialTheme.colorScheme.background // Optional, for title text color
                                ),
                                modifier = Modifier.shadow(elevation = 15.dp),
                                navigationIcon = {

                                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                                contentDescription = "Arrow Back",
                                                modifier = Modifier.clickable {
                                                        navController.popBackStack()
                                                })

                                }

                        )
                }
        ) {    innerPadding->

                Surface(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

                        Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Top
                        ) {
                               Text(text = newMovieList[0].title , modifier = Modifier.padding(12.dp), style =MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                                //Text(text = "TITLE" , modifier = Modifier.padding(12.dp), style =MaterialTheme.typography.titleLarge, color = Color.Black )
                                HorizontalDivider()
                                LazyRow {
                                        items(newMovieList[0].images) {
                                                image ->

                                                Card(modifier = Modifier.padding(12.dp)
                                                        .size(240.dp),
                                                        elevation = CardDefaults.cardElevation(5.dp)){

                                                        AsyncImage(
                                                                model = image,
                                                                contentDescription = newMovieList[0].title+" Poster",
                                                                modifier = Modifier.fillMaxSize(),
                                                                contentScale = ContentScale.Crop,
                                                                )
                                                }

                                        }
                                }

                        }
                }

        }



}