package com.example.asignment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.asignment.Activity.VideoAccounting
import com.example.asignment.Class.Video
import com.example.asignment.R

class VideoListAdapter internal constructor(context:Context): RecyclerView.Adapter<VideoListAdapter.VideoViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var videoList = emptyList<Video>()
    val context1: Context = context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoViewHolder {
        val itemView = inflater.inflate(R.layout.display_video_list_layout, parent, false)
        return VideoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val videoRecord = videoList.get(position)

        holder.title.text = videoRecord.title
        holder.video.loadUrl(videoRecord.video)
        holder.title.setOnClickListener{
            val intent = Intent(context1,  VideoAccounting::class.java)
            context1.startActivity(intent)
        }
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoListView: LinearLayout  = itemView.findViewById(R.id.displayVideoLayout)
        val title: TextView = itemView.findViewById(R.id.textViewTitle)
        val video:WebView = itemView.findViewById(R.id.videoPlayer)
    }
    internal fun setVideoList(videoList: List<Video>) {
        this.videoList = videoList
        notifyDataSetChanged()

    }
}


