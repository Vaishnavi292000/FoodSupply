package com.example.gdevkotlinproject.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.firstkotlinproject.AppDB
import com.example.firstkotlinproject.UserDetails
import com.example.gdevkotlinproject.R
import com.example.gdevkotlinproject.SideNav

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        var name: EditText =root.findViewById(R.id.name)
        var item: EditText =root.findViewById(R.id.item)
        var pack: EditText =root.findViewById(R.id.pack)
        var quantity: EditText =root.findViewById(R.id.quantity)
        var descp: EditText =root.findViewById(R.id.descp)
        var submit: Button =root.findViewById(R.id.submit)
        var db = databaseBuilder(root.context, AppDB::class.java,"food").build()
        var rnds = (0..10000000).random()
        val intent= activity?.intent
        submit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Thread{
                    var login= UserDetails()

                    login.lid=(0..10000000).random()
                    login.name=name.text.toString()
                    login.item=item.text.toString()
                    login.pack=pack.text.toString()
                    login.quantity=quantity.text.toString()
                    login.descp=descp.text.toString()
                    db.loginDao().login(login)


                    db.loginDao().readlogin().forEach(){
//                        login.lid=it.lid
//                        db.loginDao().delete(login)
                        Log.i("pass","password is: ${it.name}")
                        Log.i("pass","password is: ${it.item}")
                        Log.i("pass","password is: ${it.pack}")
                        Log.i("pass","password is: ${it.quantity}")
                        Log.i("pass","password is: ${it.descp}")
                    }
                }.start()
                startActivity(Intent(root.context, SideNav::class.java))
                activity?.finish()
            }
        })
        return root
    }
}
