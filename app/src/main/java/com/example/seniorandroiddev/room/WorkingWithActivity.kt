package com.example.seniorandroiddev.room

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seniorandroiddev.R
import com.example.seniorandroiddev.databinding.ActivityWorkingWithBinding
import com.example.seniorandroiddev.room.adapter.MyRecyclerAdapter
import com.example.seniorandroiddev.room.db.Subscriber
import com.example.seniorandroiddev.room.db.SubscriberDatabase
import com.example.seniorandroiddev.room.db.SubscriberRepository
import com.example.seniorandroiddev.room.viewmodel.SubscriberModelViewFactory
import com.example.seniorandroiddev.room.viewmodel.SubscriberViewModel

class WorkingWithActivity : AppCompatActivity() {


    private lateinit var binding: ActivityWorkingWithBinding
    private lateinit var viewModel: SubscriberViewModel

    private lateinit var adapter: MyRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_working_with)
        val dao = SubscriberDatabase.getInstance(application).subscriberDao
        val repository = SubscriberRepository(dao)
        val factory = SubscriberModelViewFactory(repository)
        viewModel = ViewModelProvider(this, factory)[SubscriberViewModel::class.java]


        binding.myviewmodel = viewModel

        viewModel.message.observe(this) {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(
                    this, it,
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }

        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.subscribersRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerAdapter { selectedItem: Subscriber -> listItemClicked(selectedItem) }
        binding.subscribersRecyclerview.adapter = adapter
        displaySubscribersList()
    }

    private fun displaySubscribersList() {
        viewModel.subscribers.observe(this) {
            Log.i("SUBS TAGS", it.toString())

            adapter.setList(it)
            adapter.notifyDataSetChanged()

        }
    }

    fun listItemClicked(subscriber: Subscriber) {
//        Toast.makeText(this, "Clicked name is: ${subscriber.name}", Toast.LENGTH_LONG)
//            .show()

        viewModel.initUpdateAndDelete(subscriber)
    }
}