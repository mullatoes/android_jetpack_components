package com.example.seniorandroiddev.recyclerviewFundamentals

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.seniorandroiddev.R

class MyRecyclerViewAdapter(
    private val fruits: List<Fruit>,
    private val clickListener: (Fruit) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layout = LayoutInflater.from(parent.context)
        val listItem = layout.inflate(R.layout.list_item, parent, false)

        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruitName = fruits[position]
        holder.bind(fruitName, clickListener)
    }

}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.textView2)
        myTextView.text = "This is ${fruit.name} from ${fruit.supplierName}"

        view.setOnClickListener {
          clickListener(fruit)
        }
    }

}