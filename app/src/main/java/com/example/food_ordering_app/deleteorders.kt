package com.example.food_ordering_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class deleteorders : AppCompatActivity() {
    lateinit var session:SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deleteorders)
        var apiClient=application as ApiClient
        var orderid=intent.getIntExtra("orderid",0)
        var intentt= Intent(this,MyOrders::class.java)
        var token=SessionManager(this).fetchAuthToken()
        CoroutineScope(Dispatchers.IO).launch {
            var result=apiClient.apiService.DeleteOrders("Bearer "+token,orderid)
            withContext(Dispatchers.Main){
            if(result.isSuccessful){
                Toast.makeText(this@deleteorders,"Deleted Successfully",Toast.LENGTH_LONG).show()
               startActivity(intentt)
            }
            else{
                Toast.makeText(this@deleteorders,"Delete not Successfull",Toast.LENGTH_LONG).show()
                startActivity(intentt)
            }
        }}
    }
}