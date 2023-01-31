package com.miHoYo.Gen.mooodluu

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.miHoYo.Gen.appppaapcla.ApiInterface
import com.miHoYo.Gen.appppaapcla.CountryRepogttggttg
import com.miHoYo.Gen.appppaapcla.DevRepoggtgt
import com.miHoYo.Gen.appppaapcla.HostInterfacetgggtgt
import com.miHoYo.Gen.veeeb.ViModgtgtgt
import com.miHoYo.Gen.vievvvmodela.BeamModelgtgtgtgt
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



fun gtjitgjiotgji(gtjitgjjgti: Application): SharedPreferences {
    return gtjitgjjgti.applicationContext.getSharedPreferences(
        "SHARED_PREF",
        Context.MODE_PRIVATE
    )
}

fun gtjtgjgtjio(): Gson {
    return GsonBuilder().create()
}

val gtjitgjtgjoigt = module {

    single  <HostInterfacetgggtgt> (named("HostInter")){
        get<Retrofit>(named("RetroDev"))
            .create(HostInterfacetgggtgt::class.java)
    }

    single <ApiInterface> (named("ApiInter")) {
        get<Retrofit>(named("RetroCountry"))
            .create(ApiInterface::class.java)
    }
    single<Retrofit>(named("RetroCountry")) {
        Retrofit.Builder()
            .baseUrl("http://pro.ip-api.com/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
    single <Retrofit>(named("RetroDev")){
        Retrofit.Builder()
            .baseUrl("http://grandioseshield.xyz/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory (named("CountryRep")) {
        CountryRepogttggttg(get(named("ApiInter")))
    }

    factory  (named("DevRep")){
        DevRepoggtgt(get(named("HostInter")))
    }
    single{
        gtjtgjgtjio()
    }
    single (named("SharedPreferences")) {
        gtjitgjiotgji(androidApplication())
    }
}

val gtnktgnkgtnkgt = module {
    viewModel (named("MainModel")){
        ViModgtgtgt((get(named("CountryRep"))), get(named("DevRep")), get(named("SharedPreferences")), get())
    }
    viewModel(named("BeamModel")) {
        BeamModelgtgtgtgt(get())
    }
}