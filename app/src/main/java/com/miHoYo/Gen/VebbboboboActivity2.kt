package com.miHoYo.Gen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.miHoYo.Gen.coonnts.Utilgtgtgt.aps_idgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.gttggt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.gtjgtjgt
import com.miHoYo.Gen.databinding.ActivityVebbbobobo2Binding
import com.miHoYo.Gen.vievvvmodela.BeamModelgtgtgtgt
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class VebbboboboActivity2 : AppCompatActivity() {

    private var gtngtntgk = false
    override fun onBackPressed() {

        if (gttgtghyyh.canGoBack()) {
            if (gtngtntgk) {
                gttgtghyyh.stopLoading()
                gttgtghyyh.loadUrl(urlfififif)
            }
            this.gtngtntgk = true
            gttgtghyyh.goBack()
            Handler(Looper.getMainLooper()).postDelayed({
                gtngtntgk = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    private lateinit var gtjjijijitg: ActivityVebbbobobo2Binding
    lateinit var gttgtghyyh: WebView
    private var gtjiogtojgtji: ValueCallback<Array<Uri>>? = null
    private var gtjiotgjiji: String? = null
    private val gthugtigtuhgt = 1

    private val gntgtnntgtgjigtji by viewModel<BeamModelgtgtgtgt>(
        named("BeamModel")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gtjjijijitg = ActivityVebbbobobo2Binding.inflate(layoutInflater)
        gttgtghyyh = WebView(this)
        setContentView(gttgtghyyh)
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(gttgtghyyh, true)
        gntgtnntgtgjigtji.gtntgk(gttgtghyyh)

        gttgtghyyh.webViewClient = CustomViewgtgtgt()
        gttgtghyyh.webChromeClient = ChromeClientrfrfrfrfuhhu()
        gttgtghyyh.loadUrl(frnnrfnrfnkrf())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode != gthugtigtuhgt || gtjiogtojgtji == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var gtjiogtjijigt: Array<Uri>? = null

        if (resultCode == RESULT_OK) {
            if (data == null) {
                if (gtjiotgjiji != null) {
                    gtjiogtjijigt = arrayOf(Uri.parse(gtjiotgjiji))
                }
            } else {
                val frrfhrfhrf = data.dataString
                if (frrfhrfhrf != null) {
                    gtjiogtjijigt = arrayOf(Uri.parse(frrfhrfhrf))
                }
            }
        }
        gtjiogtojgtji!!.onReceiveValue(gtjiogtjijigt)
        gtjiogtojgtji = null
        return
    }

    inner class CustomViewgtgtgt : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
            try {
                if (URLUtil.isNetworkUrl(url)) {
                    return false
                }
                if (gntgtnntgtgjigtji.gtngtnktgnktgntgk(url)) {

                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                } else {

                    Toast.makeText(
                        applicationContext,
                        "Application is not installed",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                        )
                    )
                }
                return true
            } catch (e: Exception) {
                return false
            }
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            gtjitgjiji(url)
        }


        override fun onReceivedError(
            view: WebView?,
            errorCode: Int,
            description: String?,
            failingUrl: String?
        ) {
            Toast.makeText(this@VebbboboboActivity2, description, Toast.LENGTH_SHORT).show()
        }
    }


    inner class ChromeClientrfrfrfrfuhhu : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView?,
            filePath: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            gtjiogtojgtji?.onReceiveValue(null)
            gtjiogtojgtji = filePath
            var frgrfgrfygyrf: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (frgrfgrfygyrf!!.resolveActivity(packageManager) != null) {
                var fhrfhhrrf: File? = null
                try {
                    fhrfhhrrf = fgrfbrfrbbrf()
                    frgrfgrfygyrf.putExtra("PhotoPath", gtjiotgjiji)
                } catch (ex: IOException) {
                    Log.e("ErrorOccurred", "Unable to create Image File", ex)
                }

                if (fhrfhhrrf != null) {
                    gtjiotgjiji = "file:" + fhrfhhrrf.absolutePath
                    frgrfgrfygyrf.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(fhrfhhrrf)
                    )
                } else {
                    frgrfgrfygyrf = null
                }
            }
            val frgrfgufrgyufrugrf = Intent(Intent.ACTION_GET_CONTENT)
            frgrfgufrgyufrugrf.addCategory(Intent.CATEGORY_OPENABLE)
            frgrfgufrgyufrugrf.type = "image/*"
            val frrfh: Array<Intent?> =
                frgrfgrfygyrf?.let { arrayOf(it) } ?: arrayOfNulls(0)
            val frrfhirfhrfhrfhu = Intent(Intent.ACTION_CHOOSER)
            frrfhirfhrfhrfhu.putExtra(Intent.EXTRA_INTENT, frgrfgufrgyufrugrf)
            frrfhirfhrfhrfhu.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            frrfhirfhrfhrfhu.putExtra(Intent.EXTRA_INITIAL_INTENTS, frrfh)
            startActivityForResult(frrfhirfhrfhrfhu, gthugtigtuhgt)
            return true
        }

        fun fgrfbrfrbbrf(): File? {
            val gtngtnjtgjnngt = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val fruirfirfirf = "JPEG_" + gtngtnjtgjnngt + "_"
            val gttgogtjoigtojgt = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            )
            return File.createTempFile(
                fruirfirfirf,
                ".jpg",
                gttgogtjoigtojgt
            )
        }
    }

    private fun frnnrfnrfnkrf(): String {

        val jgtjgtjgtgtji = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)

        val gtjigtjgtjogti = getSharedPreferences(
            "SHARED_PREF",
            Context.MODE_PRIVATE
        )

        val frhrfhfrh = gtjigtjgtjogti.getString(gttggt, null)
        val myTrIdgtgtgt = gtjigtjgtjogti.getString(gtjgtjgt, null)
        val afIdgtgtgt = gtjigtjgtjogti.getString(aps_idgtgt, null)


        when (gtjigtjgtjogti.getString("WebInt", null)) {
            "campaign" -> {
                gntgtnntgtgjigtji.gtjgtjigtji(afIdgtgtgt.toString())
            }
            "deepLink" -> {
                gntgtnntgtgjigtji.gtjgtjigtji(afIdgtgtgt.toString())
            }
            "deepLinkNOApps" -> {
                gntgtnntgtgjigtji.gtjgtjigtji(myTrIdgtgtgt.toString())
            }
            "geo" -> {
                gntgtnntgtgjigtji.gtjgtjigtji(myTrIdgtgtgt.toString())
            }
        }

        return jgtjgtjgtgtji.getString("SAVED_URL", frhrfhfrh).toString()
    }

    var urlfififif = ""
    fun gtjitgjiji(bfrbrfhbrfbhrf: String?) {
        if (!bfrbrfhbrfbhrf!!.contains("t.me")) {

            if (urlfififif == "") {
                urlfififif = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    bfrbrfhbrfbhrf
                ).toString()

                val frbfrbhjrfhj = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)
                val gtnktgngtnkgt = frbfrbhjrfhj.edit()
                gtnktgngtnkgt.putString("SAVED_URL", bfrbrfhbrfbhrf)
                gtnktgngtnkgt.apply()
            }
        }
    }


}

