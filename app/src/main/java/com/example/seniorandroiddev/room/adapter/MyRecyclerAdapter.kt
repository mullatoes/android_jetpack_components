package com.example.seniorandroiddev.room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.seniorandroiddev.R
import com.example.seniorandroiddev.databinding.SubscriberListItemBinding
import com.example.seniorandroiddev.room.db.Subscriber

class MyRecyclerAdapter(
    private val clickListener: (Subscriber) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {

    private val subscriberList =  ArrayList<Subscriber>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: SubscriberListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.subscriber_list_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return subscriberList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscriberList[position], clickListener)
    }

    fun setList(subscribers: List<Subscriber>){
        subscriberList.clear()
        subscriberList.addAll(subscribers)
    }
}

class MyViewHolder(val binding: SubscriberListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit) {
        binding.textViewName.text = subscriber.name
        binding.textViewEmail.text = subscriber.email

        binding.subscribersListId.setOnClickListener {
            clickListener(subscriber)
        }
    }
}