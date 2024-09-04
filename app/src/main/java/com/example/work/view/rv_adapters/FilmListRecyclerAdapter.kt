package com.example.work.view.rv_adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.work.view.rv_viewholders.FilmViewHolder
import com.example.work.R
import com.example.work.domain.Film


//в параметр передаем слушатель, чтобы мы потом могли обрабатывать нажатия из класса Activity
class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Здесь у нас хранится список элементов для RV
    internal val items = mutableListOf<Film>()

    //В этом методе мы привязываем наш ViewHolder и передаем туда "надутую" верстку нашего фильма
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilmViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        )
    }

    override fun getItemCount() = items.size

    //В этом методе будет привязка полей из объекта Film к View из film_item.xml
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //Проверяем, какой у нас ViewHolder
        when (holder) {
            is FilmViewHolder -> {
                //Вызываем метод bind(), который мы создали, и передаем туда объект
                //из нашей базы данных с указанием позиции
                holder.bind(items[position])
                //Обрабатываем нажатие на весь элемент целиком(можно сделать на отдельный элемент
                //например, картинку) и вызываем метод нашего листенера, который мы получаем из
                //конструктора адаптера
                holder.itemView.findViewById<CardView>(R.id.item_container).setOnClickListener{
                    clickListener.click(items[position])
                }
            }
        }
    }

  //Метод для добавления объектов в наш список
  @SuppressLint("NotifyDataSetChanged")
  fun addItems(list: List<Film>){
      //Сначала очищаем(если не реализовать DiffUtils)
        items.clear()
      //Добавляем
      items.addAll(list)
      //Уведомляем RV, что пришел новый список, и ему нужно заново все "привязывать"
      notifyDataSetChanged()
    }
    //Интерфейс для обработки кликов
    fun interface OnItemClickListener{
        fun click (film: Film)
    }

}