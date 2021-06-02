package com.example.lab6.data

import com.example.lab6.data.model.JsonData

interface IDataSource {
    fun getData(callback: DataCallback,link : String)

    interface DataCallback {
        fun onSuccess(data: JsonData)
        fun onFailure()
    }
}