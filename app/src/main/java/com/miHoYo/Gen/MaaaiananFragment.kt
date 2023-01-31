package com.miHoYo.Gen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.miHoYo.Gen.veeeb.ViModgtgtgt
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class MaaaiananFragment : Fragment() {
    private lateinit var gtjiotgjgtjio: Context

    private fun ghgihigthtggt() {
        findNavController().navigate(R.id.action_maaaiananFragment_to_cooontryryyFragment)
    }

    val viewMainModelgtgtgtgt by activityViewModel<ViModgtgtgt>(named("MainModel"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maaaianan, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        gtjiotgjgtjio=context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewMainModelgtgtgtgt.gtjitgjogtji(gtjiotgjgtjio)

        ghgihigthtggt()

    }


}