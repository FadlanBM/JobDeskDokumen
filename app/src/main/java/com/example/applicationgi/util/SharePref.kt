package com.example.applicationgi.util

import android.content.Context
import android.content.SharedPreferences

class SharePref private constructor(context: Context){
    companion object{
        private const val Preft_name="MyApp"
        private const val Preft_Token="token"

        @Volatile
        private var instance:SharePref?=null
        fun getInstance(context: Context):SharePref=
            instance?: synchronized(this){
                instance?: SharePref(context.applicationContext).also { instance=it }
            }
    }

    private val sharePref:SharedPreferences=
        context.getSharedPreferences(Preft_name,Context.MODE_PRIVATE)

    fun setToken(token:String){
        sharePref.edit().putString(Preft_Token,token).apply()
    }
    fun getToken():String?{
       return sharePref.getString(Preft_Token,null)
    }

}