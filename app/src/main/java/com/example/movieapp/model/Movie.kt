package com.example.movieapp.model

data class Movie(val id:String,
                 val title:String,
                 val year:String,
                 val genre:String,
                 val director:String,
                 val actors:String,
                 val plot:String,
                 val poster:String,
                 val images: List<String>,
                 val rating:String
    )

fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            id = "1",
            title = "Inception",
            year = "2010",
            genre = "Action, Sci-Fi, Thriller",
            director = "Christopher Nolan",
            actors = "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page",
            plot = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.",
            poster = "https://m.media-amazon.com/images/I/51sBr4IWDwL._AC_.jpg",
            images = listOf(
                "https://m.media-amazon.com/images/I/51sBr4IWDwL._AC_.jpg",
                "https://i.etsystatic.com/12345678/r/il/abcdef/1234567890/il_570xN.1234567890_abcdef.jpg"
            ),
            rating = "8.8"
        ),
        Movie(
            id = "2",
            title = "The Dark Knight",
            year = "2008",
            genre = "Action, Crime, Drama",
            director = "Christopher Nolan",
            actors = "Christian Bale, Heath Ledger, Aaron Eckhart",
            plot = "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.",
            poster = "https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg",
            images = listOf(
                "https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg",
                "https://i.etsystatic.com/87654321/r/il/abcdef/0987654321/il_570xN.0987654321_abcdef.jpg"
            ),
            rating = "9.0"
        ),
        Movie(
            id = "3",
            title = "Interstellar",
            year = "2014",
            genre = "Adventure, Drama, Sci-Fi",
            director = "Christopher Nolan",
            actors = "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
            plot = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            poster = "https://m.media-amazon.com/images/I/71n58QxE0nL._AC_SY679_.jpg",
            images = listOf(
                "https://m.media-amazon.com/images/I/71n58QxE0nL._AC_SY679_.jpg",
                "https://i.etsystatic.com/23456789/r/il/abcdef/1122334455/il_570xN.1122334455_abcdef.jpg"
            ),
            rating = "8.6"
        )
    )
}

