package net.clara.it.claranet_template_android.screen.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.clara.it.claranet_template_android.model.News

class HomeScreenViewModel() : ViewModel() {
    private val news = MutableLiveData<List<News>>()

    fun getNews() = news as LiveData<List<News>>

    init {


        addNews(News(
            "https://www.sportevai.it/uploads/2022/08/Bremer_MG0_3160.jpg",
            "svizzera",
            "oggi, 7:46",
            "Il giovane Auger-Aliassime sorprende Federer",
            "Niente undicesimo titolo ad Halle per Kink Roger, aliminato agli ottavi di finale"
        ))
        addNews(News(
            "https://staticfanpage.akamaized.net/wp-content/uploads/2019/06/NEWS-SFONDI-AREE_21-1024x493.jpg",
            "attualità",
            "oggi, 12:56",
            "Il giovane Auger-Aliassime sorprende Federer",
            "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."
        ))
        addNews(News(
            "https://i.ytimg.com/vi/RIdI4YUMYOc/maxresdefault.jpg",
            "cinema",
            "oggi, 12:56",
            "Top 20",
            "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."
        ))

    }

    fun addNews(news: News){
        this.news.value = this.news.value?.plus(news) ?: listOf(news)
    }
}