package com.miHoYo.Gen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.miHoYo.Gen.databinding.FragmentGomo3Binding
import kotlinx.coroutines.delay
import kotlin.random.Random


class Gomo3Fragment : Fragment() {
    private var hyhhy: FragmentGomo3Binding? = null
    private val hyhyjiki get() = hyhhy ?: throw RuntimeException("FragmentGomo3Binding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        hyhhy = FragmentGomo3Binding.inflate(inflater, container, false)
        return hyhyjiki.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            val currentPoint = Random.nextInt(from = 100, until = 6000)
            Snackbar.make(
                hyhyjiki.root,
                "You recived $currentPoint points",
                Snackbar.LENGTH_LONG
            ).show()


            lifecycleScope.launchWhenCreated {
                delay(1900)
                findNavController().navigate(R.id.action_gomo3Fragment_to_gomo1Fragment)
            }


        } catch (e: Exception) {
            vfvvf()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    override fun onDestroy() {
        hyhhy = null
        super.onDestroy()
    }

    private fun vfvvf() {
        Snackbar.make(
            hyhyjiki.root,
            "Some error inside...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

}