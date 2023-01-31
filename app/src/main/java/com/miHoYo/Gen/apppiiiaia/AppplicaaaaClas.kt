package com.miHoYo.Gen.apppiiiaia

import android.app.Application
import android.content.Context
import com.miHoYo.Gen.coonnts.Utilgtgtgt.ONESIGNAL_APP_IDggt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.gtggt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.mtKeygtgtgt
import com.miHoYo.Gen.coonnts.Utilgtgtgt.gtjgtjgt
import com.miHoYo.Gen.mooodluu.gtjitgjtgjoigt
import com.miHoYo.Gen.mooodluu.gtnktgnkgtnkgt
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import io.branch.referral.Branch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import java.util.*

class AppplicaaaaClas:Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_IDggt)
        Branch.enableTestMode()
        Branch.getAutoInstance(this)

        val shPgttg = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val settingsgttg = getSharedPreferences("PREFS_NAME", 0)

        val trackerParamsgtgtgt = MyTracker.getTrackerParams()
        val trackerConfiggtgt = MyTracker.getTrackerConfig()
        val instIDgtgttg = MyTracker.getInstanceId(this)
        trackerConfiggtgt.isTrackingLaunchEnabled = true
        val IDINgtgt = UUID.randomUUID().toString()

        if (settingsgttg.getBoolean("my_first_time", true)) {
            trackerParamsgtgtgt.setCustomUserId(IDINgtgt)
            shPgttg.edit().putString(gtjgtjgt, IDINgtgt).apply()
            shPgttg.edit().putString(gtggt, instIDgtgttg).apply()
            settingsgttg.edit().putBoolean("my_first_time", false).apply()
        } else {
            val shIDINgtgtgt = shPgttg.getString(gtjgtjgt, IDINgtgt)
            trackerParamsgtgtgt.setCustomUserId(shIDINgtgtgt)
        }
        MyTracker.initTracker(mtKeygtgtgt, this)

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppplicaaaaClas)
            modules(
                listOf(
                    gtnktgnkgtnkgt, gtjitgjtgjoigt
                )
            )
        }
    }
}