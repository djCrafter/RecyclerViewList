package com.example.recyclerviewlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_parts.layoutManager = LinearLayoutManager(this)
        rv_parts.hasFixedSize()

        var testData = createTestData()
        rv_parts.adapter = PartAdapter(testData, {partItem : PartData -> partItemClicked(partItem)})

    }

    private fun createTestData() : List<PartData> {
        var partList = ArrayList<PartData>()
        partList.add(PartData("Potatoes", "info about...", null))
        partList.add(PartData("Pizza", "info about...", R.drawable.pizza))
        partList.add(PartData("Sushi", "info about...", null))
        partList.add(PartData("Hot-Dog", "info about...", R.drawable.hotdog))
        partList.add(PartData("Burito", "info about...", null))
        partList.add(PartData("Burger", "info about...", R.drawable.burger))
        partList.add(PartData("Kebab", "info about...", null))
        partList.add(PartData("ICE-Cream", "info about...", R.drawable.icecream))

        return partList
    }

    private fun partItemClicked(partItem: PartData) {
        Toast.makeText(this, "Clicked: ${partItem.itemName}", Toast.LENGTH_LONG).show()
    }

}
