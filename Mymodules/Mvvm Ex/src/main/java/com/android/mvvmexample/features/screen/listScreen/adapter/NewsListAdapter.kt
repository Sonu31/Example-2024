package com.android.mvvmexample.features.screen.listScreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mvvmexample.R
import com.android.mvvmexample.data.model.Article
import com.android.mvvmexample.databinding.RowLayoutBinding
import com.bumptech.glide.Glide


class  NewsListAdapter (var list: List<Article>, var context: Context, var onItemClickListener: AdapterOnItemClickListener) :
RecyclerView.Adapter<NewsListAdapter.MyViewHolder>() {
    class MyViewHolder(var bind:RowLayoutBinding,onItemClickListener: AdapterOnItemClickListener): RecyclerView.ViewHolder(bind.root)  {
        fun viewBind(index: Article) {
          /*  Glide.with(itemView.context)
                .load(index.urlToImage)
                .into(bind.categoryImageview)*/

            bind.tv.text = index.title
//            bind.infoid.text = index.info
        }



        init {
            itemView.setOnClickListener {
                onItemClickListener.onClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false),onItemClickListener)

    }

    override fun getItemCount(): Int {
     return   list.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
            holder.viewBind(list[position])
        println("Data Testing ${list[position].urlToImage}")

        Glide.with(holder.itemView.context)
            .load(list[position].urlToImage)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.bind.categoryIv)
    }
}

interface AdapterOnItemClickListener {
    fun onClick( position: Int)
}