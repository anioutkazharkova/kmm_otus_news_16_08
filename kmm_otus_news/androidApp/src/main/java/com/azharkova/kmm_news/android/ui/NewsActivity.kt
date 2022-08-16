package com.azharkova.news.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.kmm_news.android.R
import com.azharkova.kmm_news.data.NewsItem
import com.azharkova.kmm_news.data.NewsList
import com.azharkova.kmm_news.presentation.INewsListPresenter
import com.azharkova.kmm_news.presentation.INewsListView
import com.azharkova.kmm_news.presentation.NewsListPresenter
import com.azharkova.news.adapter.NewsAdapter

class NewsActivity : AppCompatActivity(), INewsListView{
    private val presenter: INewsListPresenter by lazy {
        val presenter = NewsListPresenter()
        presenter.attachView(this)
        presenter
    }

    private var listView: RecyclerView? = null


    private var adapter: NewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        listView = findViewById<RecyclerView>(R.id.news_list)
        listView?.layoutManager = LinearLayoutManager(this)

    }

    override fun setupNews(data: NewsList) {
        if (adapter == null){
            adapter = NewsAdapter()
        }
        listView?.adapter = adapter
        adapter?.update(data.articles)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadNews()
    }

}
