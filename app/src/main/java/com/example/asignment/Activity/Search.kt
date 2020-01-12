package com.example.asignment.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.asignment.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.android.synthetic.main.activity_search.*


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
                view: View,
                position: Int,
                id: Long
            ) {
                val sharedPreference: SharedPreferences = getSharedPreferences("Article",0)
                var editor = sharedPreference.edit()
                val intent = Intent(applicationContext, Articles::class.java)

                if(list.get(position).equals("What is Accounting?")){
                    editor.putString("Article","accounting")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What is Agriculture?")){
                    editor.putString("Article","agriculture")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What is Business?")){
                    editor.putString("Article","business")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What is Software Engineering?")){
                    editor.putString("Article","software")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What does a doctor do?")){
                    editor.putString("Article","medical")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What is a mechanic?")){
                    editor.putString("Article","mechanic")
                    editor.commit()

                    startActivity(intent)
                }
            }
        })

        buttonSignIn.setOnClickListener(){
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
        }
        buttonCreate.setOnClickListener(){
            val intent = Intent(applicationContext, SignUp_From::class.java)
            startActivity(intent)
        }
    }

}
