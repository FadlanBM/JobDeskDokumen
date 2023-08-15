package com.example.applicationgi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var item= arrayListOf("Show All","Selesai","Belum Selesai")
        var autoComplete:AutoCompleteTextView=findViewById(R.id.cb_ordelist)
        var adapter=ArrayAdapter(this,R.layout.item_text,item)

        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener=AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val itemselected =adapterView.getItemAtPosition(i)
            Toast.makeText(this,"Item : $itemselected",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cusotm_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.tb_settings->{
                Toast.makeText(this, "Click Settigns", Toast.LENGTH_SHORT).show()
                return true
            } else->super.onOptionsItemSelected(item)
        }
    }
}