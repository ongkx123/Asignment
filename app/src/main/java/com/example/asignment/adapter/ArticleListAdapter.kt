package com.example.asignment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.asignment.Activity.Articles
import com.example.asignment.Class.Article
import com.example.asignment.R
import com.squareup.picasso.Picasso

class ArticleListAdapter internal constructor(context: Context): RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var articleList = emptyList<Article>()
    val context1: Context = context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val itemView = inflater.inflate(R.layout.display_article_layout, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articleRecord = articleList.get(position)

        Picasso.get().load(articleRecord.image).into(holder.articleImage)
        holder.articleTitle.text = articleRecord.title

        holder.articleTitle.setOnClickListener{
            val intent = Intent(context1,  Articles::class.java)
            context1.startActivity(intent)
        }

    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val articleListView: LinearLayout = itemView.findViewById(R.id.articleLayout)
        val articleImage:ImageView = itemView.findViewById(R.id.imageViewArticle)
        val articleTitle:TextView = itemView.findViewById(R.id.textViewArticle)

    }
    internal fun setArticleList(articleList: List<Article>) {
        this.articleList = articleList
        notifyDataSetChanged()

    }
}


