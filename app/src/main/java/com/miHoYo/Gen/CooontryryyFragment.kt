package com.miHoYo.Gen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.miHoYo.Gen.coonnts.Utilgtgtgt.geoCogtgt
import com.miHoYo.Gen.veeeb.ViModgtgtgt
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class CooontryryyFragment : Fragment() {
    private lateinit var gtjgtjgtjojgt: Context


    val frrfbrfhrfbhjrf: SharedPreferences by inject(named("SharedPreferences"))
    val viewMainModelgttggt by activityViewModel<ViModgtgtgt>(named("MainModel"))

    lateinit var countrygtgtgt: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cooontryryy, container, false)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        gtjgtjgtjojgt = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewMainModelgttggt.countgtjiotgjogtjoyCode.observe(viewLifecycleOwner) {
            if (it!=null) {
                countrygtgtgt = it.cou
                frrfbrfhrfbhjrf.edit().putString(geoCogtgt, countrygtgtgt).apply()
                frhrfhrfirfirfh()
            }
        }
    }

    private fun frhrfhrfirfirfh() {
        findNavController().navigate(R.id.action_cooontryryyFragment_to_seeecciciMainFragment)
    }
}