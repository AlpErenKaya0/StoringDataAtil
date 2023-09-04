package com.alperen.storingdataatil

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alperen.storingdataatil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferences
    var userAgePref: Int? = null

    var myAge: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPref = this.getSharedPreferences("com.alperen.storingdataatil", Context.MODE_PRIVATE)

        /*neden private ekleyemiyorum */
        userAgePref = sharedPref.getInt("age", 0)
        if (userAgePref == 0) {
            binding.textView.text = "your age: $userAgePref"
        } else {
            binding.textView.text = "your age: $userAgePref"
        }
    }

    fun save(view: View) {
        myAge = binding.editText.text.toString().toIntOrNull()
        if (myAge != null) {
            binding.textView.text = "your age is:" + myAge!!
            sharedPref.edit().putInt("age", myAge!!).apply()

        } else {
            binding.textView.text = "age!"

        }
    }

    fun delete(view: View) {
        userAgePref = sharedPref.getInt("age", 0)
        if (userAgePref != 0) {
            sharedPref.edit().remove("age").apply()
            binding.textView.text = "your age:"
        }
    }
}