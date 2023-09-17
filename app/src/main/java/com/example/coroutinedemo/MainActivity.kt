package com.example.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(Dispatchers.IO).launch{
//            Log.i("LinLi", "Calculation started: ");
//            val stock1 = async { getStock1() }
//            val stock2 = async { getStock2() }
//            //調用兩個async的返回值
//            val total = stock1.await()+stock2.await()
//            Log.i("LinLi", "Total is: $total");
//        }

        CoroutineScope(Dispatchers.Main).launch{
            Log.i("LinLi", "Calculation started: ");
            val stock1 = async(Dispatchers.IO) { getStock1() }
            val stock2 = async(Dispatchers.IO) { getStock2() }
            //調用兩個async的返回值
            val total = stock1.await()+stock2.await()
            Toast.makeText(applicationContext,"Total is: $total", Toast.LENGTH_LONG)
                .show()
        }
    }

    private suspend fun getStock1() : Int{
        delay(10000)
        Log.i("LinLi", "stock 1 returned ");
        return 55000
    }
    private suspend fun getStock2() : Int{
        delay(8000)
        Log.i("LinLi", "stock 2 returned ");
        return 55000
    }
}