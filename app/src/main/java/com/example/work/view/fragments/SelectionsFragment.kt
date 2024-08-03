package com.example.work.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.work.databinding.FragmentSelectionsBinding
import com.example.work.utils.AnimationHelper

class SelectionsFragment : Fragment() {
private lateinit var b: FragmentSelectionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentSelectionsBinding.inflate(layoutInflater, container, false)
        return  b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(b.selectionsFragmentRoot, requireActivity(), 3)
    }
}