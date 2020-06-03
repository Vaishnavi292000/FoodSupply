package com.example.gdevkotlinproject.ui.gallery

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstkotlinproject.UserDetails
import com.example.gdevkotlinproject.R
import kotlinx.android.synthetic.main.food_card.view.*

class AdapterFood(val ctx: Context, val food: List<UserDetails>) : RecyclerView.Adapter<AdapterFood.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(ctx)
        val view = inflater.inflate(R.layout.food_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount()=food.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.view.name.text=food[position].name
        holder.view.item.text=food[position].item
        holder.view.quant.text=food[position].quantity
        holder.view.desp.text=food[position].descp


        Log.i("pass","adapter is: ${food[position].name}")
        Log.i("pass","password is: ${food[position].item}")
//        Log.i("pass","password is: ${it.pack}")
//        Log.i("pass","password is: ${it.quantity}")
//        Log.i("pass","password is: ${it.descp}")

    }

    class ViewHolder(val view:View):RecyclerView.ViewHolder(view) {

    }

}