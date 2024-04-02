package com.example.listadapters_and_diffutils_components

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapters_and_diffutils_components.adapter.ProgramAdapter
import com.example.listadapters_and_diffutils_components.databinding.ActivityMainBinding
import com.example.listadapters_and_diffutils_components.model.ProgramItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = ProgramAdapter()

        val p1 = ProgramItem(1, "J", "Java")
        val p2 = ProgramItem(2, "K", "Kotlin")
        val p3 = ProgramItem(3, "A", "Android")

        adapter.submitList(listOf(p1, p2, p3))

        binding.recyclerProgrammingList.layoutManager = LinearLayoutManager(this)
        binding.recyclerProgrammingList.setHasFixedSize(true)
        binding.recyclerProgrammingList.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val p3 = ProgramItem(1, "A", "Android")
                val p4 = ProgramItem(1, "R", "Rust")
                val p5 = ProgramItem(1, "N", "Node")
                val p6 = ProgramItem(1, "G", "GoLang")

                adapter.submitList(listOf(p3, p4, p5, p6))
            }, 4000
        )

    }
}