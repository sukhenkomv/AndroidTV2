package ru.novotelecom.androidtv2

import android.content.Context
import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter


class MyItemPresenter: Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder? {
        return ViewHolder(ImageCardView(parent.context))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        val view = viewHolder.view as ImageCardView
        val context: Context = view.context
        val title = item as String?
        view.titleText = title
        view.contentText = null
        view.mainImage = context.getDrawable(R.drawable.pizza)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {}

}