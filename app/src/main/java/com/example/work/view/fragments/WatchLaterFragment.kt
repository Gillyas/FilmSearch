package com.example.work.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.work.databinding.FragmentWatchLaterBinding
import com.example.work.utils.AnimationHelper

class WatchLaterFragment : Fragment() {
private lateinit var binding: FragmentWatchLaterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWatchLaterBinding.inflate(layoutInflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(binding.watchLaterFragmentRoot, requireActivity(), 2)
    }
}