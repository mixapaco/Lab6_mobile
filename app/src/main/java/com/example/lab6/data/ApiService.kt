package com.example.lab6.data

import com.example.lab6.data.api.RetrofitApiHelper
import com.example.lab6.data.api.GeterApi
import com.example.lab6.data.model.JsonData
import com.example.lab6.data.di.DiHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestApiService : IDataSource {

    companion object {
        const val SECRET_KEY = "\$2b\$10\$.DI8X0edWswId/0Onz5ZROiSd.v83bvOyBY2w.zH/MIIwvgNERKKa"
    }

    var api: GeterApi
    init {

        api = DiHelper.getRetrofitHelper().retrofit!!.create(GeterApi::class.java)
    }
    override fun getData(callback: IDataSource.DataCallback, link : String) {
        api.getData(SECRET_KEY,link).enqueue(object : Callback<JsonData> {
            override fun onResponse(call: Call<JsonData>, response: Response<JsonData>) {
                if (response.code() == 200 && response.body() != null)
                    callback.onSuccess(response.body()!!)
                else
                    callback.onFailure()
            }
            override fun onFailure(call: Call<JsonData>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}