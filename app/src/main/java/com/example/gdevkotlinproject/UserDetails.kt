package com.example.firstkotlinproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
class UserDetails {
    @PrimaryKey
    var lid:Int=0
    @ColumnInfo(name="name")
    var name:String =""
    @ColumnInfo(name="item")
    var item:String =""
    @ColumnInfo(name="pack")
    var pack:String =""
    @ColumnInfo(name="quantity")
    var quantity:String =""
    @ColumnInfo(name="descp")
    var descp:String =""

}