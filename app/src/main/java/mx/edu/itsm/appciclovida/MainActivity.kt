package mx.edu.itsm.appciclovida

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import mx.edu.itsm.appciclovida.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? =null
    private var posicion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show()
        Log.i("Ciclo de Vida", "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this,R.raw.bigban)
        mediaPlayer?.start()
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(posicion)
        mediaPlayer?.start()
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if(mediaPlayer != null)
            posicion = mediaPlayer!!.currentPosition
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show()
    }
}