package com.example.application_teste

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnNext1 = findViewById<Button>(R.id.button4)
        btnNext1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Encontra o botão para reproduzir o áudio
        val btnPlayAudio = findViewById<Button>(R.id.button12)
        // Configura um ouvinte de clique para o botão
        btnPlayAudio.setOnClickListener {
            // Chama a função para reproduzir o áudio
            playAudio()
        }
    }

    private fun playAudio() {
        // Verifica se o MediaPlayer já foi criado
        if (mediaPlayer == null) {
            // Cria o MediaPlayer com o arquivo de áudio da pasta res/raw
            mediaPlayer = MediaPlayer.create(this, R.raw.gemido)
        }

        // Verifica se o áudio está reproduzindo e para
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
            mediaPlayer?.seekTo(0) // Reinicia o áudio
        }

        // Inicia a reprodução do áudio
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Libera o recurso do MediaPlayer quando a atividade for destruída
        mediaPlayer?.release()
        mediaPlayer = null
    }
}