package com.alexkand.homeworkkotlin_18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Сделать приложение в котором будет один экран и две кнопки и ImageView.
// У первой кнопки текст Load image. У второй кнопки текст Change button's text.
// По нажатию на первую кнопку должна запускаться coroutine в которой мы загружаем картинку
// (выбор картинки на ваше усмотрение) через Glide.
// По нажатию на вторую кнопку запускается coroutine,
// которая изменяет текст второй кнопки на "It's Kotlin!".

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FirstFragment()).commit()
    }
}