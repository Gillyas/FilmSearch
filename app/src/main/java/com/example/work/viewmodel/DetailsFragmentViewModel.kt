package com.example.work.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModel
import java.net.URL
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class DetailsFragmentViewModel: ViewModel() {
    suspend fun loadWallpaper(url: String):Bitmap{
        return suspendCoroutine {
            val url = URL(url)
            val bitmap =
                BitmapFactory.decodeStream(url.openConnection().getInputStream())
            it.resume(bitmap)
        }
    }
}
//suspend fun loadWallpaper(url: String): Bitmap {
//    Помечаем функцию как suspend, потому как у нас будет логика показа Прогресс-бара, а также тоста в конце, и нам необходима прерывающаяся функция, которая будет возвращать объект Bitmap.
//
//    return suspendCoroutine {
//        Как вы помните, само по себе слово suspend никакой магии не делает, это просто маркер, а нам нужен объект Continuation, поэтому мы используем метод suspendCoroutine, чтобы получить к нему доступ.
//
//        val url = URL(url)
//        val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
//        Далее мы загружаем файл из Сети вот таким нехитрым образом. В URL из представления мы будем передавать адрес картинки.
//
//        it.resume(bitmap)
//        Как вы помните, чтобы suspend функция не «потерялась» и продолжила свою работу, нужно вызывать метод resume, а в нашем случае ещё возвращать и bitmap.

