package com.miHoYo.Gen.veeeb

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsflyer.AFInAppEventParameterName
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.miHoYo.Gen.appppaapcla.CountryCodeJSgtgtgt
import com.miHoYo.Gen.appppaapcla.CountryRepogttggttg
import com.miHoYo.Gen.appppaapcla.DevRepoggtgt
import com.miHoYo.Gen.appppaapcla.GeoDevgtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.apappapspspsps
import io.branch.referral.util.BRANCH_STANDARD_EVENT
import io.branch.referral.util.BranchEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViModgtgtgt(
    private val gtjitgjogtji: CountryRepogttggttg,
    private val devRepogttggt: DevRepoggtgt,
    private val shPgttggt: SharedPreferences,
    val applicationgtgtgt: Application
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            gfjghtgu()
        }
        viewModelScope.launch(Dispatchers.Main) {
            gtjiotgjigtjiogt()
        }
    }

    private val gtjitgjiojgti = MutableLiveData<CountryCodeJSgtgtgt>()
    val countgtjiotgjogtjoyCode: LiveData<CountryCodeJSgtgtgt>
        get() = gtjitgjiojgti

    private val _geogttg = MutableLiveData<GeoDevgtgtgt>()
    val geogtgtgt: LiveData<GeoDevgtgtgt>
        get() = _geogttg

    private val _appsDatagttggt = MutableLiveData<String>()
    val gtjtgjjti: LiveData<String>
        get() = _appsDatagttggt

    private val _mainIdgttggt = MutableLiveData<String?>()
    val mainIdgtgtgt: LiveData<String?>
        get() = _mainIdgttggt


    suspend fun gtjiotgjigtjiogt() {
        gtjitgjiojgti.postValue(gtjitgjogtji.getDat().body())
        gtjigtjogtjig()
    }

    suspend fun gtjigtjogtjig() {
        _geogttg.postValue(devRepogttggt.getDataDev().body())
    }

    fun conversgtgtgt(gtntgnkgtn: Context) {
        AppsFlyerLib.getInstance()
            .init(apappapspspsps, gthgthgthgtiu, applicationgtgtgt)
        AppsFlyerLib.getInstance().start(gtntgnkgtn)
    }

    fun gtjitgjogtji(gtnjtgngt: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            gtnjtgngt
        ) { data: AppLinkData? ->
            data?.let {
                val gtjtgjtgjtgji = data.targetUri?.host.toString()
                shPgttggt.edit().putString("deepSt", gtjtgjtgjtgji).apply()
            }
        }
    }

    private val gthgthgthgtiu = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val gtjiogtjiogtji = data?.get("campaign").toString()
            _appsDatagttggt.postValue(gtjiogtjiogtji)

            when (data?.get(AFInAppEventParameterName.AF_CHANNEL).toString()) {
                "ACI_Search" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.ACHIEVE_LEVEL).setDescription("ACI_Search")
                        .logEvent(applicationgtgtgt.applicationContext)

                }
                "ACI_Youtube" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.SHARE).setDescription("ACI_Youtube")
                        .logEvent(applicationgtgtgt.applicationContext)


                }
                "ACI_Display" -> {
                    BranchEvent(BRANCH_STANDARD_EVENT.RATE).setDescription("ACI_Display")
                        .logEvent(applicationgtgtgt.applicationContext)

                }

                else -> {


                    BranchEvent(BRANCH_STANDARD_EVENT.VIEW_AD).setDescription("NoChannel")
                        .logEvent(applicationgtgtgt.applicationContext)
                    Log.d("Branch Check", "I'm here, branch bitch! No source though")
                }

            }

        }

        override fun onConversionDataFail(error: String?) {
        }

        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
        }

        override fun onAttributionFailure(error: String?) {
        }
    }


    fun gfjghtgu() {
        val gtngtntgntgj = AdvertisingIdClient(applicationgtgtgt)
        gtngtntgntgj.start()
        val gtnntgngtngt = gtngtntgntgj.info.id.toString()
        _mainIdgttggt.postValue(gtnntgngtngt)
    }

}