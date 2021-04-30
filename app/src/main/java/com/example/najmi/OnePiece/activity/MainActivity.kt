package com.example.najmi.OnePiece.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.najmi.OnePiece.R
import com.example.najmi.OnePiece.R.array.*
import com.example.najmi.OnePiece.adapter.OnePieceAdapter
import com.example.najmi.OnePiece.entity.Item
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        OnePiece_list.layoutManager = LinearLayoutManager(this)
        OnePiece_list.adapter = OnePieceAdapter(this, items) { itemClicked(it) }

    }

    private fun initData(){
        val name = resources.getStringArray(personnage_name)
        val image = resources.obtainTypedArray(personnage_image)
        val description = resources.getStringArray(personnage_description)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0), description[i]))
        }

        //Recycle the typed array
        image.recycle()
    }

    private fun itemClicked(items : Item) {
        startActivity<DetailActivity>(DetailActivity.TITLE to items.name, DetailActivity.IMAGE to items.image, DetailActivity.DESCRIPTION to items.description)
    }
}
