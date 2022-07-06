package com.isanapp.mysubmission2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.isanapp.mysubmission2.R
import com.isanapp.mysubmission2.model.Follower
import kotlinx.android.synthetic.main.item_follower.view.*

class FollowerAdapter(private val followers: ArrayList<Follower>) :
    RecyclerView.Adapter<FollowerAdapter.RecyclerViewHolder>() {

    fun setFollowerData(item: ArrayList<Follower>) {
        followers.clear()
        followers.addAll(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_government, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = followers.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) =
        holder.bind(followers[position])

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(follower: Follower) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(follower.avatar)
                    .apply { RequestOptions().override(100, 100) }
                    .into(id_avatar)
                tv_item_username.text = follower.username
                tv_item_id.text = follower.id.toString()
                tv_item_type.text = follower.type
            }
        }
    }
}