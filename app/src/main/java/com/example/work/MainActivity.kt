package com.example.work

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.work.R.drawable
import com.example.work.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val view = binding.root
        setContentView(view)
        val filmsDatabase = listOf(
            Film("Росомаха", drawable.pic, ""),
            Film("Человек-Паук", drawable.pic2, "Старый Новый Человек-Паук"),
            Film("Обитель Зла", drawable.pic3, "Убиватель зомби"),
            Film("Балерина", drawable.pic4, "Танцевать - это круто!"),
            Film("Цвет Фиолетовый", drawable.pic5, "Фильм про самый лучший цвет"),
            Film("Стальной Ноготь", drawable.pic6, "Конор В прошлом"),
            Film("Лица, Места", drawable.pic7, "This should be a description"),

            )

        //находим наш RV

        binding.mainRecycler.apply {
            filmsAdapter = FilmListRecyclerAdapter (object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film){
                val bundle = Bundle()
                bundle.putParcelable("film", film)
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

        filmsAdapter.addItems(filmsDatabase)

        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

    }


    }



