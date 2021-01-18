package abika.sinau.myfirstgooglemaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val alAzharBekasi = LatLng(-6.2230992,107.0013453)
        val gubugMakanMangEngking = LatLng(-6.2286863,107.0024923)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        // ganti warna marker
        mMap.addMarker(MarkerOptions()
            .position(alAzharBekasi)
            .title("Al Azhar Bekasi")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(alAzharBekasi))

        // add 2 marker + snippet
        mMap.addMarker(MarkerOptions()
            .position(gubugMakanMangEngking)
            .title("Gubug Mang Engking")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_rider_black))
            .snippet("Warung Makan Mang Engking"))

        // setting zoom
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(alAzharBekasi, 15f))

        // add setting zoom-in and zoom-out
        mMap.uiSettings.isZoomControlsEnabled = true

        // add setting kompas
        mMap.uiSettings.isCompassEnabled = true

        // add mapType
        btnHybrid.setOnClickListener {
            mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        }

        btnSatelite.setOnClickListener {
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        }

        btnTerrain.setOnClickListener {
            mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
        }

        btnNormal.setOnClickListener {
            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        }
    }
}