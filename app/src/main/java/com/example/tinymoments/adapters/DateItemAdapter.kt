package com.example.tinymoments.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tinymoments.R
import com.example.tinymoments.models.MonthDay
import com.example.tinymoments.utils.Constants

open class DateItemAdapter(private val context : Context, private val dates: ArrayList<MonthDay>, private val today: MonthDay) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DateItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_date, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val date = dates[position]
        val tvMonth = holder.itemView.findViewById<TextView>(R.id.tv_month)
        val tvDay = holder.itemView.findViewById<TextView>(R.id.tv_day)
        val cardView = holder.itemView.findViewById<CardView>(R.id.date_card_view)
        if(date.day == today.day){
            cardView.setCardBackgroundColor(context.resources.getColor(R.color.custom_green,))
            tvMonth.setTextColor(context.resources.getColor(R.color.white))
            tvDay.setTextColor(context.resources.getColor(R.color.white))

        }
        holder.itemView.findViewById<TextView>(R.id.tv_month).text = Constants.dateToMonth[date.month]
        holder.itemView.findViewById<TextView>(R.id.tv_day).text = date.day.toString()
    }

    override fun getItemCount(): Int {
        Log.e("DateItemAdapter", "Size is ${dates.size}")
        return dates.size
    }

    private class DateItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}