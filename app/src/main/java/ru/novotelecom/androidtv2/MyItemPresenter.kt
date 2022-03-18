package ru.novotelecom.androidtv2

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.leanback.widget.Presenter


class MyItemPresenter: Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        (viewHolder as ItemHolder).bind(item)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {}
}

class ItemHolder (itemView: View): Presenter.ViewHolder(itemView) {
    private val image: ImageView = itemView.findViewById(R.id.listItemImageID)
    private val title: TextView = itemView.findViewById(R.id.listItemTextID)

    fun bind(
        item: Any?
    ) {
        title.text = item as String
    }
}