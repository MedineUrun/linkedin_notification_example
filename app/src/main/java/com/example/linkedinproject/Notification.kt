package com.example.linkedinproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Notification(val id:Int, val content:String, val profile:String, var isRead:Boolean = false):
        Parcelable{

        }
