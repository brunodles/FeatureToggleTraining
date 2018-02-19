package com.brunodles.workshop.featuretoggle

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContentAdapter(private val onClickListener: (position: Int) -> Unit) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    companion object {
        private const val SIZE: Int = 100
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = position.toString()
        holder.itemView.setOnClickListener {
            onClickListener.invoke(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dashboard, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = SIZE


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text: TextView = itemView.findViewById(R.id.text)

    }
}