package com.example.ktwishlist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var recView: RecyclerView? = null
    var userData: MutableList<UserData>? = null
    var newname: EditText? = null
    var newprice: EditText? = null
    var newurl: EditText? = null
    var submit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newname = findViewById(R.id.name)
        newprice = findViewById(R.id.price)
        newurl = findViewById(R.id.url)
        submit = findViewById(R.id.submit)
        userData = ArrayList()
        recView = findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(this)
        recView.setLayoutManager(linearLayoutManager)
        val adapter = CustomAdapter(userData)
        recView.setAdapter(adapter)
        
        submit.setOnClickListener(View.OnClickListener {
            val name = newname.getText().toString()
            val price = newprice.getText().toString()
            val url = newurl.getText().toString()
            val mUserData = UserData(name, price, url)
            userData.add(mUserData)
            adapter.notifyDataSetChanged()
            clearFields()
        })
    }

    private fun clearFields() {
        newname!!.setText("")
        newprice!!.setText("")
        newurl!!.setText("")
    }
}
