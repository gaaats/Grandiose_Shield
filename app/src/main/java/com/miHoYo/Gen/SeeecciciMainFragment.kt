package com.miHoYo.Gen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.miHoYo.Gen.coonnts.Utilgtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.codeCodegtgttg
import com.miHoYo.Gen.coonnts.Utilgtgtgt.gtkgtjiogt
import com.miHoYo.Gen.veeeb.ViModgtgtgt
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class SeeecciciMainFragment : Fragment() {
    val gtnjtgtg by activityViewModel<ViModgtgtgt>(named("MainModel"))
    lateinit var gtjitgjiogt: String
    lateinit var gtntijgtgtjiogt: String
    lateinit var appsgtgtgt: String
    private lateinit var mContextgtgt: Context

    val sharePgtgtgt: SharedPreferences by inject(named("SharedPreferences"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_seeeccici_main, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContextgtgt = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frhrghgithuigthhitgh()

        gtnjtgtg.geogtgtgt.observe(viewLifecycleOwner) {
            if (it != null) {

                gtjitgjiogt = it.geo
                appsgtgtgt = it.appsChecker
                gtntijgtgtjiogt = it.view

                sharePgtgtgt.edit().putString(codeCodegtgttg, gtjitgjiogt).apply()
                sharePgtgtgt.edit().putString(Utilgtgtgt.appsgtgtgt, appsgtgtgt).apply()
                sharePgtgtgt.edit().putString(gtkgtjiogt, gtntijgtgtjiogt).apply()

                rfhhrfrfhhrfrfh()
            }
        }
    }

    private fun frhrghgithuigthhitgh() {
        gtnjtgtg.mainIdgtgtgt.observe(viewLifecycleOwner) {
            if (it != null) {
                val main = it.toString()
                sharePgtgtgt.edit().putString("mainId", main).apply()
            }
        }
    }

    private fun rfhhrfrfhhrfrfh() {
        findNavController().navigate(R.id.action_seeecciciMainFragment_to_prrreefFragment)
    }
}