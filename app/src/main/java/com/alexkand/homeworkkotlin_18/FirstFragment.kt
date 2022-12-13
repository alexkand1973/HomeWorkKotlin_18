package com.alexkand.homeworkkotlin_18

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.*
import kotlinx.coroutines.NonDisposableHandle.parent
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import java.lang.System.load
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


class FirstFragment : Fragment(R.layout.fragment_first) {

    val loadImage = "https://placepic.ru/wp-content/uploads/2019/05/s1200-14.jpg"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        coroutinesWork()
    }

    private fun coroutinesWork(){
        btn_load_image.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                Glide.with(requireContext()).load(loadImage)
                    .into(iv_loading_image)
            }
        }

        btn_change_text.setOnClickListener {
            val coroutineTask = CoroutineScope(Dispatchers.IO).async {
                sayItsKotlin()
            }

            CoroutineScope(Dispatchers.Main).launch {
                Log.e("TAG", "${this.coroutineContext}")
                val newText = coroutineTask.await()
                btn_change_text.text = newText
            }
        }
    }
    private fun sayItsKotlin() : String {
        return "It's Kotlin!"
    }
}
