package com.miHoYo.Gen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.miHoYo.Gen.coonnts.Utilgtgtgt.appsgtgtgt
import com.miHoYo.Gen.veeeb.ViModgtgtgt
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class PrrreefFragment : Fragment() {

    val gthugthgthgtgt by activityViewModel<ViModgtgtgt>(named("MainModel"))
    val sharePgttg: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var appCampgtgt: String
    private lateinit var mContextgtgttg: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContextgtgttg = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prrreef, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkFlygtgtgt = sharePgttg.getString(appsgtgtgt, null)
        val appsCampgttggt = sharePgttg.getString("appCamp", null)

        if (checkFlygtgtgt=="1" &&appsCampgttggt == null) {
            gthugthgthgtgt.conversgtgtgt(mContextgtgttg)
            gthugthgthgtgt.gtjtgjjti.observe(viewLifecycleOwner) {
                if (it != null) {
                    appCampgtgt = it.toString()
                    sharePgttg.edit().putString("appCamp", appCampgtgt).apply()
                    hgthhgttghgt()
                }
            }
        } else {
            hgthhgttghgt()
        }
    }

    private fun hgthhgttghgt() {
        findNavController().navigate(R.id.action_prrreefFragment_to_fiiilalalaFragment)
    }

}