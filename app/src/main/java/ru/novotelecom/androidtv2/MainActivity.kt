package ru.novotelecom.androidtv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.Visibility

class MainActivity : AppCompatActivity() {

    lateinit var gridView: MyGridView
    lateinit var gridViewWrapper: FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridViewWrapper = findViewById(R.id.gridViewWrapper)

        gridView = supportFragmentManager.findFragmentById(R.id.myGridView) as MyGridView

        gridView.setSelectedPosition(0)

        gridView.setOnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
            Log.i("OnItemViewClicked", item as String)
        }

        gridView.setOnItemViewSelectedListener { itemViewHolder, item, rowViewHolder, row ->
            Log.i("OnItemViewSelected", item as String)
        }



        val gridPresenter = MyGridPresenter()
        gridPresenter.numberOfColumns = 1

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

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                if (gridViewWrapper.isVisible) {
                    gridViewWrapper.visibility = View.INVISIBLE
                    return true
                }
                if (!gridViewWrapper.isVisible) {
                    gridViewWrapper.visibility = View.VISIBLE
                    return true
                }
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}