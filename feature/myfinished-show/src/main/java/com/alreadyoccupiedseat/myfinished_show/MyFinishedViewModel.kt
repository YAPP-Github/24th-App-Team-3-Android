package com.alreadyoccupiedseat.myfinished_show

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alreadyoccupiedseat.model.Artist
import com.alreadyoccupiedseat.model.Genre
import com.alreadyoccupiedseat.model.Show
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyFinishedViewModel @Inject constructor() : ViewModel() {

    private val _showList = mutableStateOf<List<Show>>(emptyList())
    val showList: State<List<Show>> = _showList

    init {
        loadShowsWithDelay()
    }

    private fun loadShowsWithDelay() {
        viewModelScope.launch {
            // TODO RealData
            delay(3000)
            _showList.value = (1..10).map { index ->
                val genres = listOf(
                    "Rock",
                    "Band",
                    "EDM",
                    "Classic",
                    "Hiphop",
                    "House",
                    "Opera",
                    "Pop",
                    "Rnb",
                    "Musical",
                    "Metal",
                    "Jpop",
                    "Jazz"
                )
                val genreName = genres[(index - 1) % genres.size]
                val posterImageURL = if (index % 2 != 0) {
                    "https://img.hankyung.com/photo/202406/01.37069998.1.jpg"
                } else {
                    "https://thumb.mt.co.kr/06/2024/04/2024040913332068429_1.jpg/dims/optimize/"
                }

                Show(
                    artist = Artist(
                        id = index.toString(),
                        imageUrl = "https://example.com/artist$index.jpg",
                        koreanName = "Artist $index",
                        englishName = "Artist $index"
                    ),
                    genre = Genre(
                        id = index.toString(),
                        image = "https://example.com/genre$index.jpg",
                        name = genreName
                    ),
                    id = index.toString(),
                    name = "Concert $index",
                    posterImageURL = posterImageURL,
                    ticketingAndShowInfo = listOf(/* ... */)
                )
            }
        }
    }

}