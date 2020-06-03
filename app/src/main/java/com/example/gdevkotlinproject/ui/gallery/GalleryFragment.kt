package com.example.gdevkotlinproject.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.firstkotlinproject.AppDB
import com.example.gdevkotlinproject.R
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        var db = Room.databaseBuilder(root.context, AppDB::class.java, "food").allowMainThreadQueries().build()
        var foodRecycler:RecyclerView=root.findViewById(R.id.foodRecycler)
        var allfood=db.loginDao().readlogin()
        foodRecycler.apply {
            layoutManager=LinearLayoutManager(root.context)
            adapter=AdapterFood(root.context,allfood)
        }
        return root
    }
}
