package com.example.asignment.Activity

import android.app.SearchManager
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.example.asignment.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mancj.materialsearchbar.MaterialSearchBar

class Search : AppCompatActivity() {
    private val db = FirebaseDatabase.getInstance()
    private val profile = db.getReference("article")
    private var list : MutableList<String> = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val lv = findViewById(R.id.mListView) as ListView
        val searchBar = findViewById(R.id.searchBar) as MaterialSearchBar

        //Retrieve values from firebase
        profile.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                //Get firebase values
                for(i: DataSnapshot in dataSnapshot.children.iterator()){
                    list.add(i.child("title").value.toString())

                }
            }


            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Search,"Error",Toast.LENGTH_SHORT).show()
            }
        })

        searchBar.setHint("Search..")
        searchBar.setSpeechMode(true)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        lv.setAdapter(adapter)

        searchBar.addTextChangeListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.getFilter().filter(charSequence)
            }

        })

        lv.setOnItemClickListener(object: AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val intent = Intent(applicationContext, ArticleAccounting::class.java)
                startActivity(intent)
            }

        })













    }
}
