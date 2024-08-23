package com.alreadyoccupiedseat.myfavorite_show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alreadyoccupiedseat.model.Artist
import com.alreadyoccupiedseat.model.Genre
import com.alreadyoccupiedseat.model.Show
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MyFavoriteShowState(
    val showList: List<Show> = emptyList(),
)

@HiltViewModel
class MyFavoriteShowViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<MyFavoriteShowState>(MyFavoriteShowState())
    val state = _state

    init {
        loadShowsWithDelay()
    }

    private fun loadShowsWithDelay() {
        viewModelScope.launch {
            // TODO RealData
            delay(3000)

            _state.value = _state.value.copy(showList =
            (1..10).map { index ->
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
                    "https://www.dailypop.kr/news/photo/201509/12537_8555_1158.JPG"
                } else {
                    "https://cdnimage.dailian.co.kr/news/201502/news_1423016119_486190_m_1.jpg"
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
            })

        }
    }

    fun deleteMyFavoriteShow(id: String) {
        viewModelScope.launch {
            _state.emit(
                _state.value.copy(
                    showList = _state.value.showList.filter { it.id != id }
                )
            )
        }
    }

}