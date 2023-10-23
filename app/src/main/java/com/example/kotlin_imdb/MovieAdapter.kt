package com.example.kotlin_imdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(val results : ArrayList<MainModel.Movie>, val listener: OnAdapterListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    )

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.view.findViewById<TextView>(R.id.movie_title).text = result.title
        holder.view.findViewById<TextView>(R.id.release_date).text = "Release Date: ${result.release_date}"
        holder.view.findViewById<TextView>(R.id.popularity).text = "Popularity: ${result.popularity}"

        Glide.with(holder.view.context)
            .load("https://image.tmdb.org/t/p/w500${result.poster_path}")
            .centerCrop()
            .into(holder.view.findViewById(R.id.movie_image))

        holder.view.findViewById<CardView>(R.id.item_card).setOnClickListener{
            listener.onClick(result)
        }

    }

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view){

    }

    fun setData(data: List<MainModel.Movie>){
        results.clear()
        results.addAll(data)

        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onClick(movie: MainModel.Movie)
    }
}