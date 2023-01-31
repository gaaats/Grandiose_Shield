package com.miHoYo.Gen.appppaapcla

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getData(): Response<CountryCodeJSgtgtgt>
}

interface HostInterfacetgggtgt {
    @GET("typo.json")
    suspend fun getDataDev(): Response<GeoDevgtgtgt>
}

class CountryRepogttggttg(private val countryApi: ApiInterface) {
    suspend fun getDat() = countryApi.getData()
}
class DevRepoggtgt(private val devData: HostInterfacetgggtgt) {
    suspend fun getDataDev() = devData.getDataDev()
}

@Keep
data class CountryCodeJSgtgtgt(
    @SerializedName("countryCode")
    val cou: String,
)


@Keep
data class GeoDevgtgtgt(
    @SerializedName("geo")
    val geo: String,
    @SerializedName("view")
    val view: String,
    @SerializedName("appsChecker")
    val appsChecker: String,
)