package com.example.food_ordering_app

import retrofit2.Response
import retrofit2.http.*

interface ApiService {
   @POST(Constants.Register_URL)
     suspend fun Register(@Body request: RegisterUser)

    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest):Response<LoginResponse>
   @GET("/eaterapp/dishes")
   suspend fun GetDishes(@Header("Authorization") token: String):Response<FooditemsList>
   @POST("/eaterapp/users/me/orders")
   suspend fun PlaceOrders(@Header("Authorization") token: String,@Body request: Dishes):Response<Unit>
   @GET("/eaterapp/users/me/orders")
   suspend fun fetchOrders(@Header("Authorization") token: String):Response<OrdersHistoryList>
   @DELETE("/eaterapp/users/me/orders/{orderId}")
   suspend fun DeleteOrders(@Header("Authorization") token: String,@Path("orderId")orderId:Int):Response<Unit>
}