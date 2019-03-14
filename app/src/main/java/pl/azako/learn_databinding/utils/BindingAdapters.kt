package pl.azako.learn_databinding.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import pl.azako.learn_databinding.R
import pl.azako.learn_databinding.data.MainViewModel

object BindingAdapters {

    @BindingAdapter("app:hideIfZero")
    @JvmStatic
    fun hideIfZero(view: View, num: Int) {
        view.visibility = if (num == 0) View.INVISIBLE else View.VISIBLE
    }

    @BindingAdapter(value = ["android:progressScaled", "android:max"], requireAll = true)
    @JvmStatic
    fun setProgress(progressBar: ProgressBar, likes: Int, max: Int) {
        progressBar.progress = likes
    }

    @BindingAdapter("app:popularityIcon")
    @JvmStatic
    fun popularityIcon(view: ImageView, popularity: MainViewModel.Popularity) {
        var color = getAssociatedColor(popularity, view.context)
        ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(color))
        view.setImageDrawable(getDrawablePopularity(popularity, view.context))
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("app:progressTint")
    @JvmStatic
    fun tintPopularity(view: ProgressBar, popularity: MainViewModel.Popularity) {
        var color = getAssociatedColor(popularity, view.context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            view.progressTintList = ColorStateList.valueOf(color)
    }

    private fun getAssociatedColor(popularity: MainViewModel.Popularity, context: Context): Int {
        return when (popularity) {
            MainViewModel.Popularity.NORMAL -> ContextCompat.getColor(context,R.color.normal)
            MainViewModel.Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
            MainViewModel.Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
        }
    }

    private fun getDrawablePopularity(popularity: MainViewModel.Popularity, context: Context): Drawable? {
        return when (popularity) {
            MainViewModel.Popularity.NORMAL -> ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
            MainViewModel.Popularity.POPULAR -> ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            MainViewModel.Popularity.STAR -> ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
        }
    }
}