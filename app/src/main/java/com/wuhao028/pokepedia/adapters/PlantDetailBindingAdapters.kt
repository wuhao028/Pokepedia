package com.wuhao028.pokepedia.adapters

import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.wuhao028.pokepedia.utilities.PokeUtils

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String) {
    Glide.with(view.context)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}

@BindingAdapter("localImage")
fun bindImageFromLocal(view: ImageView, imageName: String) {
    if (!imageName.isNullOrEmpty()) {
        val resId = view.context.resources.getIdentifier(
            imageName.replace(" ", "")
                .replace("-", "")
                .replace("_", "")
                .toLowerCase(),
            "mipmap", view.context.packageName
        )
        try {
            val drawable = ContextCompat.getDrawable(view.context, resId)
            Glide.with(view.context)
                .load(drawable)
                .into(view)
        } catch (e: Exception) {

        }
    }
}

@BindingAdapter("localGif")
fun bindGifFromLocal(view: ImageView, imageName: String) {
    if (!imageName.isNullOrEmpty()) {
        val resId = view.context.resources.getIdentifier(
            imageName.replace(" ", "")
                .replace("-", "")
                .replace("_", "")
                .toLowerCase(),
            "mipmap", view.context.packageName
        )
        try {
            val drawable = ContextCompat.getDrawable(view.context, resId)
            Glide.with(view.context)
                .load(drawable)
                .into(view)
        } catch (e: Exception) {

        }
    }
}

@BindingAdapter("setColor")
fun bindsetColor(view: ConstraintLayout, type: String) {
    val resId = PokeUtils.getColorByType(type)
    val drawable = ContextCompat.getDrawable(view.context, resId)
    view.setBackgroundDrawable(drawable)
}


@BindingAdapter("typeOne")
fun bindTypeOne(view: TextView, type: List<String>) {
    view.text = type[0]
}

@BindingAdapter("typeTwo")
fun bindTypeTwo(view: TextView, type: List<String>) {
    if (type.size == 2) {
        view.visibility = View.VISIBLE
        view.text = type[1]
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("isGone")
fun bindIsGone(view: FloatingActionButton, isGone: Boolean?) {
    if (isGone == null || isGone) {
        view.hide()
    } else {
        view.show()
    }
}

@BindingAdapter("renderHtml")
fun bindRenderHtml(view: TextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = ""
    }
}
