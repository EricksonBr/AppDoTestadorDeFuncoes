package com.example.application_teste

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity5 : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnnext = findViewById<Button>(R.id.button7)
        btnnext.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        // Inicializar o FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Associar o botão do layout pelo ID
        val getLocationButton: Button = findViewById(R.id.getLocationButton)

        // Definir um ouvinte de clique para o botão
        getLocationButton.setOnClickListener {
            // Verificar se a permissão de localização foi concedida
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // Solicitar permissão de localização se ainda não foi concedida
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_PERMISSION_REQUEST_CODE
                )
            } else {
                // Se a permissão já foi concedida, obter a localização do usuário
                requestLocation()
            }
        }
    }

    // Constante para o código de solicitação de permissão de localização
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1001
    }

    // Método para solicitar a localização atual do usuário
    private fun requestLocation() {
        // Verificar se a permissão de localização está disponível
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Obter a localização atual do usuário
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    // A localização foi obtida com sucesso
                    if (location != null) {
                        val latitude = location.latitude
                        val longitude = location.longitude
                        // Faça o que quiser com a latitude e longitude aqui
                        Toast.makeText(
                            this,
                            "Latitude: $latitude, Longitude: $longitude",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        // A localização não pôde ser obtida
                        Toast.makeText(
                            this,
                            "Não foi possível obter a localização",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    // Método para lidar com o resultado da solicitação de permissão
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array

        <String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
// Verificar se a permissão foi concedida
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
// Permissão concedida, solicitar a localização
                    requestLocation()
                } else {
// Permissão negada, mostrar uma mensagem de erro
                    Toast.makeText(
                        this,
                        "Permissão de localização negada",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}