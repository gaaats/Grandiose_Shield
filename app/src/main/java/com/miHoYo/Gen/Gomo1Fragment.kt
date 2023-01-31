package com.miHoYo.Gen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.miHoYo.Gen.databinding.FragmentGomo1Binding


class Gomo1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bbgbgbg = FragmentGomo1Binding.inflate(inflater, container, false)
        return nnhnhnh.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            nnhnhnh.btnPlayGameeee.setOnClickListener {
                try {
                    findNavController().navigate(R.id.action_gomo1Fragment_to_gomo2Fragment)
                } catch (e: Exception) {
                    Snackbar.make(
                        nnhnhnh.root,
                        "Some error, restarting...",
                        Snackbar.LENGTH_LONG
                    )
                        .show()
                }
            }

        } catch (e: Exception) {
            Snackbar.make(nnhnhnh.root, "Some error, reload...", Snackbar.LENGTH_LONG)
                .show()
        }
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        bbgbgbg = null
        super.onDestroyView()
    }

    private var bbgbgbg: FragmentGomo1Binding? = null
    private val nnhnhnh
        get() = bbgbgbg ?: throw RuntimeException("FragmentEnteringggBinding = null")


}