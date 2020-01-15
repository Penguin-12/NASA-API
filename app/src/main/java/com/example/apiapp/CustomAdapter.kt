package com.example.apiapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(internal var list: List<POJO>, internal var context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    internal lateinit var intent: Intent

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.textView.text = list[position].date

        Glide.with(context).load(list[position].url).into(holder.imageView)
        holder.constraintLayout.setOnClickListener {
            intent = Intent(context, DetailedView::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("Explanation", list[position].explanation)
            intent.putExtra("Title", list[position].title)
            intent.putExtra("ImageUrl", list[position].url)


            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textView: TextView
        internal var constraintLayout: ConstraintLayout
        internal var imageView: ImageView

        init {
            textView = itemView.findViewById(R.id.textView)
            imageView = itemView.findViewById(R.id.imageView)
            constraintLayout = itemView.findViewById(R.id.parent)
        }
    }


}
