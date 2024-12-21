package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie= getMovies()[0], onItemClick: (String) -> Unit = {}) {

    var expanded by remember { mutableStateOf(false) }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(movie.id)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){



        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){

            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                color = Color.White,
                shape= CircleShape,
                shadowElevation = 4.dp
            ){

                AsyncImage(
                    model = movie.poster,
                    contentDescription = movie.title+" Poster",
                    modifier = Modifier.size(100.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop,

                )
            }

            // Title, Director and Year
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text=movie.title,
                    style=MaterialTheme.typography.titleLarge)
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Director: ")
                        }
                        withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)){
                            append(movie.director)
                        }
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Released: ")
                        }
                        withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)){
                            append(movie.year)
                        }

                    },
                    style = MaterialTheme.typography.bodyMedium
                )

            }

            Column(modifier = Modifier.padding(4.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {

                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn() + expandVertically()
                ) {
                    Icon(imageVector = if (!expanded) {
                        Icons.Default.KeyboardArrowDown
                    } else {
                        Icons.Default.KeyboardArrowUp
                    },
                        contentDescription = "Down Arrow",
                        modifier = Modifier.clickable {
                            expanded = !expanded
                        })
                }
            }


        }
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically()
        ) {
            Row(   verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.Start // Align items to the start
                ) {
                    // Plot Section
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                                append(movie.plot)
                            }
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 4.dp) // Add spacing below this text
                    )

                    // Actors Section
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Actors: ")
                            }
                            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                                append(movie.actors)
                            }
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 4.dp) // Add spacing below this text
                    )

                    // Rating Section
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Rating: ")
                            }
                            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                                append(movie.rating)
                            }
                        },
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }


        }

    }
}