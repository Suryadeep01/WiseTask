package com.example.wisetask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wisetask.R
import com.example.wisetask.model.response.Cocktail
import com.google.android.material.textview.MaterialTextView

class Adapter(
    private val mList: List<Cocktail>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(cocktail: Cocktail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.bindData(item)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView1: MaterialTextView = itemView.findViewById(R.id.text_food_name)
        private val textView: MaterialTextView = itemView.findViewById(R.id.text_food_type)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bindData(item: Cocktail) {
            textView1.text = item.idDrink
            textView.text = item.strDrink

            Glide.with(itemView.context)
                .load(item.strDrinkThumb)
                .into(imageView)
        }
    }
}
