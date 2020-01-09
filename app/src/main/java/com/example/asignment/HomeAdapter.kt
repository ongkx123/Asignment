package com.example.asignment


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter internal constructor(context: Context):RecyclerView.Adapter<HomeAdapter.UserViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var post = emptyList<Home>()

    inner class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val userName: TextView = itemView.findViewById(R.id.textViewName)
        val status : TextView = itemView.findViewById(R.id.textViewStatus)
        val like : TextView = itemView.findViewById(R.id.textViewLike)
        val comment : TextView = itemView.findViewById(R.id.textViewComment)
        val image : ImageView = itemView.findViewById(R.id.imageViewPic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val itemView = inflater.inflate(R.layout.home_layout, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = post[position]
        holder.userName.text = current.name
        holder.status.text = current.status
        holder.like.text = current.likes.toString()
        holder.comment.text = current.comments.toString()
       /* holder.image.setImageResource(current.postpic)

        if(current.postpic == 0){
            holder.image.visibility = View.GONE
        }
        else{
            holder.image.visibility = View.VISIBLE
            holder.image.setImageResource(current.postpic)
        }*/
    }

    /*internal fun setPost(home: List<Home>) {
        this.post = post
        notifyDataSetChanged()
    }*/

    override fun getItemCount() = post.size

    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.home_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val postRecord = postList.get(position)
        holder.textViewName.text= postRecord.name
        holder.textViewTime.text= postRecord.time
        holder.textViewStatus.text= postRecord.status
        holder.textViewLike.text= postRecord.likes.toString()
        holder.textViewComment.text= postRecord.comments.toString()
        holder.image.setImageResource(postRecord.postpic)



        if(postRecord.postpic == 0){
            holder.image.visibility = View.GONE
        }
        else{
            holder.image.visibility = View.VISIBLE
            holder.image.setImageResource(postRecord.postpic)
        }
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val textViewName:TextView = itemView.findViewById(R.id.textViewName)
        val textViewTime: TextView = itemView.findViewById(R.id.textViewTime)
        val textViewStatus: TextView = itemView.findViewById(R.id.textViewStatus)
        val textViewLike: TextView = itemView.findViewById(R.id.textViewLike)
        val textViewComment: TextView = itemView.findViewById(R.id.textViewComment)
        val image:ImageView = itemView.findViewById(R.id.imageViePic)
    }*/
}





