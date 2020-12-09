package com.cuc.infoapp.utils

import com.google.gson.annotations.SerializedName


data class AddressInfo(
    @SerializedName("result")
    var result: Result,
    @SerializedName("status")
    var status: Int
) {
    data class Result(
        @SerializedName("addressComponent")
        var addressComponent: AddressComponent,
        @SerializedName("business")
        var business: String,
        @SerializedName("cityCode")
        var cityCode: Int,
        @SerializedName("formatted_address")
        var formattedAddress: String,
        @SerializedName("location")
        var location: Location,
        @SerializedName("poiRegions")
        var poiRegions: List<Any>,
        @SerializedName("pois")
        var pois: List<Any>,
        @SerializedName("roads")
        var roads: List<Any>,
        @SerializedName("sematic_description")
        var sematicDescription: String
    ) {
        data class Location(
            @SerializedName("lat")
            var lat: Double,
            @SerializedName("lng")
            var lng: Double
        )

        data class AddressComponent(
            @SerializedName("adcode")
            var adcode: String,
            @SerializedName("city")
            var city: String,
            @SerializedName("city_level")
            var cityLevel: Int,
            @SerializedName("country")
            var country: String,
            @SerializedName("country_code")
            var countryCode: Int,
            @SerializedName("country_code_iso")
            var countryCodeIso: String,
            @SerializedName("country_code_iso2")
            var countryCodeIso2: String,
            @SerializedName("direction")
            var direction: String,
            @SerializedName("distance")
            var distance: String,
            @SerializedName("district")
            var district: String,
            @SerializedName("province")
            var province: String,
            @SerializedName("street")
            var street: String,
            @SerializedName("street_number")
            var streetNumber: String,
            @SerializedName("town")
            var town: String
        )
    }
}