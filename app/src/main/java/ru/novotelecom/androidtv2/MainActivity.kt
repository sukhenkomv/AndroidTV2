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
import ru.novotelecom.androidtv2.model.ChannelModel

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
            Log.i("OnItemViewClicked", (item as ChannelModel).title)
        }

        gridView.setOnItemViewSelectedListener { itemViewHolder, item, rowViewHolder, row ->
            Log.i("OnItemViewSelected", (item as ChannelModel).title)
        }



        val gridPresenter = MyGridPresenter()
        gridPresenter.numberOfColumns = 1

        gridView.gridPresenter = gridPresenter

        val itemPresenter = MyItemPresenter()

        val adapter = ArrayObjectAdapter(itemPresenter)
        adapter.add(ChannelModel(1, "Первый", "http://cdn.2090000.ru/images/tvChannels/10338245.png"))
        adapter.add(ChannelModel(2, "Россия 1", "http://cdn.2090000.ru/images/tvChannels/10338258.png"))
        adapter.add(ChannelModel(3, "Матч ТВ", "http://cdn.2090000.ru/images/tvChannels/10338240.png"))
        adapter.add(ChannelModel(4, "НТВ", "http://cdn.2090000.ru/images/tvChannels/10338229.png"))
        adapter.add(ChannelModel(5, "Канал 111", "http://cdn.2090000.ru/images/tvChannels/28036134.png"))
        adapter.add(ChannelModel(6, "Канал 112", "http://cdn.2090000.ru/images/tvChannels/28036134.png"))
        adapter.add(ChannelModel(7, "Канал 113", "http://cdn.2090000.ru/images/tvChannels/28036134.png"))
        adapter.add(ChannelModel(8, "Канал 114", "http://cdn.2090000.ru/images/tvChannels/28036134.png"))
        adapter.add(ChannelModel(9, "Канал 115", "http://cdn.2090000.ru/images/tvChannels/28036134.png"))
        adapter.add(ChannelModel(10, "Канал 116", "http://cdn.2090000.ru/images/tvChannels/28036134.png"))
        adapter.add(ChannelModel(11, "Канал 117", "http://cdn.2090000.ru/images/tvChannels/28036134.png"))

        gridView.adapter = adapter
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                if (gridViewWrapper.isVisible) {
                    gridViewWrapper.visibility = View.GONE
                    return true
                }
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                if (!gridViewWrapper.isVisible) {
                    gridViewWrapper.visibility = View.VISIBLE
                    return true
                }
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}