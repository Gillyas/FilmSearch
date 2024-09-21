@file:Suppress("SpellCheckingInspection")

package com.example.work.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.work.databinding.FragmentFavoritesBinding
import com.example.work.data.e.Enity.Film
import com.example.work.utils.AnimationHelper
import com.example.work.view.MainActivity
import com.example.work.view.rv_adapters.FilmListRecyclerAdapter
import com.example.work.view.rv_adapters.TopSpacingItemDecoration


class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFavoritesBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Получаем список при транзакции фрагмента
        val favoritesList: List<Film> = emptyList()

        binding.favoritesRecycler.apply {
                filmsAdapter = FilmListRecyclerAdapter { film ->
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            //Присваиваем адаптер
                adapter = filmsAdapter
                //Присвои layoutmanager
                layoutManager = LinearLayoutManager(requireContext())
                //Применяем декоратор для отступов
                val decorator = TopSpacingItemDecoration(8)
                addItemDecoration(decorator)
            }
        AnimationHelper.performFragmentCircularRevealAnimation(binding.favoritesFragmentRoot, requireActivity(),4)
        //Кладем нашу БД в RV
        filmsAdapter.addItems(favoritesList)
            }
    }
