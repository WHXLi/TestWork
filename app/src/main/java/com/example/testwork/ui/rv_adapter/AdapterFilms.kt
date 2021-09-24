package com.example.testwork.ui.rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testwork.databinding.ItemFilmBinding
import com.example.testwork.framework.entity.Film
import com.example.testwork.mvp.presenter.rv.IPresenterListFilms
import com.example.testwork.mvp.view.rv.IViewItemFilms

class AdapterFilms(private val presenter: IPresenterListFilms) :
    RecyclerView.Adapter<AdapterFilms.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root), IViewItemFilms {
        override fun setFilm(film: Film) {
            Glide.with(itemView).load(film.multimedia.src).into(binding.itemFilmImage)
            binding.itemFilmTitle.text = film.displayTitle
            binding.itemFilmInfo.text = film.summary_short
            binding.itemFilmPagination.text = (pos+1).toString()
        }

        override var pos: Int = -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount() = presenter.getCount()
}