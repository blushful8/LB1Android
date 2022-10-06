package com.example.lb1android

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lb1android.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity(), SeekBarSettable {

    private lateinit var binding: ActivitySecondaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.addFlags(1024)

        binding.currentState.text = (50).toString()
        binding.minBtn.setOnClickListener {
            setMin()
            setCurrentState()
        }
        binding.maxBtn.setOnClickListener {
            setMax()
            setCurrentState()
        }
        binding.centerBtn.setOnClickListener {
            setCenter()
            setCurrentState()
        }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                setCurrentState()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(this@SecondaryActivity, "Success changed value", Toast.LENGTH_SHORT)
                    .show()
            }

        })

    }

    private fun setCurrentState() {
        binding.currentState.text = binding.seekBar.progress.toString()
    }

    override fun setMax() {
        val getMax = binding.seekBar.max
        binding.seekBar.progress = getMax
    }

    @SuppressLint("NewApi")
    override fun setMin() {
        val getMin = binding.seekBar.min
        binding.seekBar.progress = getMin
    }

    override fun setCenter() {
        val getCenter = binding.seekBar.max / 2
        binding.seekBar.progress = getCenter
    }
}