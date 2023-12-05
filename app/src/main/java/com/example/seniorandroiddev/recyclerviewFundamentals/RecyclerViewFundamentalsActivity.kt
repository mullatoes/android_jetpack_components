package com.example.seniorandroiddev.recyclerviewFundamentals

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seniorandroiddev.R
import com.example.seniorandroiddev.databinding.ActivityRecyclerViewFundamentalsBinding

class RecyclerViewFundamentalsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewFundamentalsBinding

    val fruits = listOf(
        Fruit(name = "Guave", supplierName = "Paul"),
        Fruit(name = "Lemon", supplierName = "Sammy"),
        Fruit(name = "Pair", supplierName = "Odiks"),
        Fruit(name = "Mango", supplierName = "Steve"),
        Fruit(name = "Avacado", supplierName = "Duncan"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_fundamentals)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyRecyclerViewAdapter(fruits) { selectedItem: Fruit ->
            selectedItemClickListener(selectedItem)
        }

    }

    private fun selectedItemClickListener(fruit: Fruit){
        Toast.makeText(
            this, "Selected fruit is: ${fruit.supplierName}", Toast.LENGTH_LONG
        ).show()
    }
}