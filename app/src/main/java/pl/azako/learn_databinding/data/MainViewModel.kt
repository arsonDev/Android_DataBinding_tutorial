package pl.azako.learn_databinding.data

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val name = "Arek"
    val lastName = "Kowalczyk"
    val likes = ObservableInt()
    val popularity = ObservableField<Popularity>(Popularity.NORMAL)

    fun onLikes(){
        likes.set(likes.get()+1)
        popularity.set(likes.get().let {
            when{
                it > 9 -> Popularity.STAR
                it > 4 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        })
    }

    enum class Popularity{
        NORMAL,
        POPULAR,
        STAR
    }
}

