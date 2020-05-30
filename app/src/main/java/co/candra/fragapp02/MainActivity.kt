package co.candra.fragapp02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {
    private var googleMap: GoogleMap?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onDestroy() {
        super.onDestroy()
        locationManager= null
        listener = null
    }
    override fun onMapReady(p0: GoogleMap?) {
        googleMap=p0


        val latLng= LatLng(6.2088,106.8456)
        val markerOptions: MarkerOptions = MarkerOptions().position(latLng).title("Jakarta")
        val zoomLevel = 12.0f //This goes up to 21

        googleMap.let {
            it!!.addMarker(markerOptions)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))
        }
    }
}
