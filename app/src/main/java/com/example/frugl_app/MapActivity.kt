package com.example.frugl_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.json.JSONException
import org.json.JSONObject

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap){
        map = googleMap

        val trenton = LatLng(40.2206, -74.7597)
        map.addMarker(MarkerOptions().position(trenton).title("Marker in Trenton"))
        map.moveCamera(CameraUpdateFactory.newLatLng(trenton))
    }
    private fun fetchNearestStores(location: LatLng) {
        val urlString = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location=${location.latitude},${location.longitude}" +
                "&radius=10000" +
                "&type=supermarket" +
                "&keyword=ShopRite" +
                "&key=@string/google_maps_key"

        // Using a hypothetical function `sendHttpRequest` to make the request.
        val jsonResponse = sendHttpRequest(urlString)

        try {
            val jsonObject = JSONObject(jsonResponse)
            val results = jsonObject.getJSONArray("results")
            for (i in 0 until results.length()) {
                val store = results.getJSONObject(i)
                val geometry = store.getJSONObject("geometry")
                val storeLocation = geometry.getJSONObject("location")

                val lat = storeLocation.getDouble("lat")
                val lng = storeLocation.getDouble("lng")

                map.addMarker(MarkerOptions().position(LatLng(lat, lng)).title(store.getString("name")))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun sendHttpRequest(urlString: String): String {
        TODO()
    }

}