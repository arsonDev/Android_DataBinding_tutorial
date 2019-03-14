package pl.azako.learn_databinding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.main.*
import pl.azako.learn_databinding.R
import pl.azako.learn_databinding.data.MainViewModel
import pl.azako.learn_databinding.databinding.MainBinding

class MainActivity : AppCompatActivity() {

    private val viewmodel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : MainBinding = DataBindingUtil.setContentView(this,
            R.layout.main)
        binding.viewModel = viewmodel
    }
}
