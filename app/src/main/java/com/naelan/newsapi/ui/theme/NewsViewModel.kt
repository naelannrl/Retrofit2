package com.naelan.newsapi.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naelan.newsapi.model.Article
import com.naelan.newsapi.network.Api
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    init {
        getListNews()
    }

    fun getListNews() {
        viewModelScope.launch {
            val response = Api.newsAPIService.getEverything()
            val articles = response.articles

            articles.forEach { article: Article ->
                Log.d("response", article.toString())
            }
        }
    }
}