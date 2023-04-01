package com.mustafanarin.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.mustafanarin.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var sure : Long =0
        binding.btnStart.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime() + sure
            binding.kronometre.start()
            binding.btnStart.visibility= View.GONE
            binding.btnPause.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }

        binding.btnPause.setOnClickListener {
            sure = binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnPause.visibility= View.GONE
            binding.btnStart.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }

        binding.btnReset.setOnClickListener {
            binding.kronometre.base= SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            sure = 0
            binding.btnPause.visibility= View.GONE
            binding.btnStart.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
    }
}