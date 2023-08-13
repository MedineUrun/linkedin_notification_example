package com.example.linkedinproject

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load

class NotificationAdapter(
    val context: Context,
    val notifications: List<com.example.linkedinproject.Notification>,
    val onClick:(notification:Notification, position:Int) -> Unit
):
    RecyclerView.Adapter<NotificationAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notifications.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val notification = notifications[position]
        holder.ivProfile.load(notification.profile)
        holder.tvFullText.text = "${notification.content}"

        if (notification.isRead){
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"))
            holder.lCircle.isVisible = false
        }else{
            holder.itemView.setBackgroundColor(Color.parseColor("#bfefff"))
            holder.lCircle.isVisible = true
        }


        holder.tvFullText.text = notifications[position].content
        holder.myItemView.setOnClickListener{
            onClick(notification,position)

        }
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val myItemView = itemView
        val ivProfile: ImageView = itemView.findViewById(R.id.ivProfile)
        val tvFullText: TextView = itemView.findViewById(R.id.tvFullText)
        val lCircle: TextView = itemView.findViewById(R.id.lCircle)
    }


}