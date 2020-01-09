package com.example.asignment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var recycleV :RecyclerView
    lateinit var postList: ArrayList<Home>
    lateinit var adapter: HomeAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val rv = inflater.inflate(R.layout.fragment_home,container,false)
        recycleV = rv.findViewById(R.id.recycleViewHome)
        recycleV.layoutManager = LinearLayoutManager(activity)
        recycleV.adapter = HomeAdapter(rv.context)
        return rv


        buttonSend.setOnClickListener{
            send(rv)
        }


       /*postList = ArrayList<Home>()

        adapter = HomeAdapter(this)
        adapter.setPost(postList)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)*/

    }
    private fun send(view: View){

        val status = editStatus.text.toString()
        val likes = 1
        val comments = 1
        val userName = "AAA"

        val ref = FirebaseDatabase.getInstance().getReference("user")

        val home = Home(status,likes,comments,userName)

        ref.child("Home").setValue(home)

        postList.add(home)
        recycleV.adapter = HomeAdapter(view.context)
    }


}
