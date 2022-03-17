package ru.novotelecom.androidtv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.VerticalGridPresenter

class MainActivity : AppCompatActivity() {

    lateinit var gridView: MyGridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = supportFragmentManager.findFragmentById(R.id.myGridViewID) as MyGridView
        gridView.title = "Title"

        val gridPresenter = MyGridPresenter()
        gridPresenter.numberOfColumns = 4

        gridView.gridPresenter = gridPresenter

        val itemPresenter = MyItemPresenter()

        val adapter = ArrayObjectAdapter(itemPresenter)
        adapter.add("Pizza 1")
        adapter.add("Pizza 2")
        adapter.add("Pizza 3")
        adapter.add("Pizza 4")
        adapter.add("Pizza 5")
        adapter.add("Pizza 6 with a very long title which will not fit")

        gridView.adapter = adapter
    }

}