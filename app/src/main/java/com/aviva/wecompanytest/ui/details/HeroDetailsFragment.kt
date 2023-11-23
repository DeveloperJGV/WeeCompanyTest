package com.aviva.wecompanytest.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aviva.wecompanytest.databinding.FragmentHeroDetailsBinding

class HeroDetailsFragment : Fragment() {

    private var _binding: FragmentHeroDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHeroDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val heroId = arguments?.getInt("HERO_ID") ?: 0
        // Utiliza heroId para cargar los detalles del superhéroe
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}