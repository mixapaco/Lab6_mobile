package com.example.lab6.data.di


import com.example.lab6.data.IDataSource
import com.example.lab6.data.TestApiService
import com.example.lab6.data.api.RetrofitApiHelper



class DiHelper {

    companion object {

        private var mainService: IDataSource? = null
        private var retrofitHelper: RetrofitApiHelper? = null


        //Singleton
        fun getService(): IDataSource {
            if (mainService == null) {
                mainService = TestApiService()
            }

            return mainService!!
        }

        //Singleton
        fun getRetrofitHelper(): RetrofitApiHelper {
            if (retrofitHelper == null) {
                retrofitHelper = RetrofitApiHelper()
                retrofitHelper?.init()
            }

            return retrofitHelper!!
        }
    }
}