package com.example.frugl_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val location = LatLng(40.730610, -73.935242)
        fetchNearestStores(location)
    }

    private fun fetchNearestStores(location: LatLng) {
        val call = RetrofitClient.instance.getNearbyPlaces(
            location = "${location.latitude},${location.longitude}",
            radius = 50000,
            type = "supermarket",
            //keyword = "ShopRite",
            apiKey = this.resources.getString(R.string.map_api_key)

        )
        Log.d("LOG_MESSAGE", "working")
        call.enqueue(object : Callback<PlacesResponse> {
            override fun onResponse(call: Call<PlacesResponse>, response: Response<PlacesResponse>) {
                if (response.isSuccessful) {
                    Log.d("LOG_MESSAGE", "Response successful")
                    val placesResponse = response.body()
                    val nearestStore = placesResponse?.results?.getOrNull(0)
                    val storeLocation = nearestStore?.geometry?.location
                    if (storeLocation != null) {
                        Log.d("LOG_MESSAGE", "Found store")
                        val store = LatLng(storeLocation.lat, storeLocation.lng)
                        map.addMarker(MarkerOptions().position(location).title("Your location"))
                        map.addMarker(MarkerOptions().position(store).title("Nearest Store"))
                        map.animateCamera(CameraUpdateFactory.newLatLngZoom(store, 13f))
                    }
                    else {
                        Log.d("LOG_MESSAGE", "No store found")
                    }
                } else {
                    Log.d("LOG_MESSAGE", "Response unsuccessful")
                }
            }

            override fun onFailure(call: Call<PlacesResponse>, t: Throwable) {
                Log.d("LOG_MESSAGE", "Failure: ${t.message}")
            }
        })
    }



}