package com.example.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.work.databinding.FragmentHomeBinding
import java.util.Locale


@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private val filmsDataBase = listOf(
        Film(
            "The Shawshank Redemption",
            R.drawable.pic,
            "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", 7.4f
        ),
        Film(
            "The Godfather",
            R.drawable.pic2,
            "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", 8.9f
        ),
        Film(
            "The Dark Knight",
            R.drawable.pic3,
            "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",9.3f
        ),
        Film(
            "Pulp Fiction",
            R.drawable.pic4,
            "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", 9.9f
        ),
        Film(
            "Inception",
            R.drawable.pic5,
            "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",5.9f
        ),
        Film(
            "Hamilton",
            R.drawable.pic6,
            "The real life of one of America's foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from the Richard Rodgers Theater with the original Broadway cast.",8.0f
        ),
        Film(
            "Gisaengchung",
            R.drawable.pic7,
            "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",9.9f
        ),

        )

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(binding.homeFragmentRoot, requireActivity(), 1)
        binding.mainRecycler.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс,
            //оставим его пока пустым, он нам понадобится во второй части задания
            filmsAdapter =
                FilmListRecyclerAdapter { film ->
                    (requireActivity() as MainActivity).launchDetailsFragment(
                        film
                    )
                }
            // тут создвли UX при нажатие на все поле происходит "активация"
            binding.searchView.setOnClickListener {
                binding.searchView.isIconified = false
            }
            //Подключаем слушателя изменений введенного текста в поиска
            binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                //Этот метод отрабатывает на каждое изменения текста
                override fun onQueryTextChange(newText: String?): Boolean {
                    //Если ввод пуст то вставляем в адаптер всю БД
                    //Если ввод пуст то вставляем в адаптер всю БД
                    if (newText!!.isEmpty()) {
                        filmsAdapter.addItems(filmsDataBase)
                        return true
                    }
                    //Фильтруем список на поискк подходящих сочетаний
                    val result = filmsDataBase.filter {
                        //Чтобы все работало правильно, нужно и запрос, и имя фильма приводить к нижнему регистру
                        it.title.lowercase(Locale.getDefault())
                            .contains(newText.lowercase(Locale.getDefault()))
                    }
                    //Добавляем в адаптер
                    filmsAdapter.addItems(result)
                    return true
                }
            })


            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
//Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }
}
