package com.miHoYo.Gen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.miHoYo.Gen.databinding.FragmentGomo2Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Gomo2Fragment : Fragment() {
    var sum = 0

    private var vfvfvf: FragmentGomo2Binding? = null
    private val juujju
        get() = vfvfvf ?: throw RuntimeException("FragmentGomo2Binding = null")

    val totto =
        "In Egyptian society, religion was central to everyday life. One of the roles of the king was as an intermediary between the deities and the people. The king thus was deputised for the deities in a role that was both as civil and religious administrator. The king owned all of the land in Egypt, enacted laws, collected taxes, and defended Egypt from invaders as the commander-in-chief of the army.[8] Religiously, the king officiated over religious ceremonies and chose the sites of new temples. The king was responsible for maintaining Maat (mꜣꜥt), or cosmic order, balance, and justice, and part of this included going to war when necessary to defend the country or attacking others when it was believed that this would contribute to Maat, such as to obtain resources."

    val liiist by lazy {
        listOf(
            ContextCompat.getDrawable(requireActivity(), R.drawable.coiin),
        ).shuffled()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vfvfvf = FragmentGomo2Binding.inflate(inflater, container, false)
        return juujju.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            amkfkrfrf()
            juujju.btnElem8.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem9.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem10.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem13.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem12.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }


            if (totto == "555") {
                Snackbar.make(
                    juujju.root,
                    totto,
                    Snackbar.LENGTH_LONG
                ).show()
            }

            juujju.root.background.alpha = 230



            juujju.btnElem1.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem2.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem3.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem4.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem5.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem6.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem7.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }


        } catch (e: Exception) {
            afrhgthUygt()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun amkfkrfrf() {
        juujju.btnElem1.setImageDrawable(liiist.random())
        juujju.btnElem2.setImageDrawable(liiist.random())
        juujju.btnElem3.setImageDrawable(liiist.random())
        juujju.btnElem4.setImageDrawable(liiist.random())
        juujju.btnElem5.setImageDrawable(liiist.random())
        juujju.btnElem6.setImageDrawable(liiist.random())
        juujju.btnElem7.setImageDrawable(liiist.random())
        juujju.btnElem8.setImageDrawable(liiist.random())
        juujju.btnElem9.setImageDrawable(liiist.random())
        juujju.btnElem10.setImageDrawable(liiist.random())
        juujju.btnElem12.setImageDrawable(liiist.random())
        juujju.btnElem13.setImageDrawable(liiist.random())
    }


    override fun onDestroy() {
        vfvfvf = null
        super.onDestroy()
    }

    private fun afrhgthUygt() {
        Snackbar.make(
            juujju.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    private fun slonny(imageView: ImageView) {
        lifecycleScope.launch {
            while (true) {
                var ismsms = bgbgbbg
                var gtjitji = plfr
                imageView.alpha = ismsms
                if (ismsms >= 1f) {
                    gtjitji = -0.05f
                }
                if (ismsms <= 0.1f) {
                    gtjitji = 0.05f
                }
                delay(30)
                ismsms += gtjitji
            }
        }
    }

    private fun isisKfjr(imageView: ImageView): Boolean {
        if (imageView.visibility == View.GONE) {
            return true
        }
        return false
    }

    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    private fun polskks() {
        sum += 1
        val ggttg = "COLLECTED: $sum"
        juujju.tvSum.text = ggttg

        if (isisKfjr(juujju.btnElem1) && isisKfjr(juujju.btnElem2) && isisKfjr(
                juujju.btnElem3
            ) && isisKfjr(juujju.btnElem4) && isisKfjr(juujju.btnElem5) && isisKfjr(
                juujju.btnElem6
            ) && isisKfjr(juujju.btnElem7) && isisKfjr(juujju.btnElem8) && isisKfjr(
                juujju.btnElem9
            ) && isisKfjr(juujju.btnElem10) && isisKfjr(juujju.btnElem13) && isisKfjr(
                juujju.btnElem12
            )
        ) {
            findNavController().navigate(R.id.action_gomo2Fragment_to_gomo3Fragment)
        }
    }

    private fun alalalet() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Exit, realy?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().finish()
            }
            .setNegativeButton("Deny") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }

    var bgbgbbg = 0.8f
    var plfr = 0.05f

}