package com.example.lab6.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JsonData {
    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("load")
    @Expose
    private var load: String? = null

    @SerializedName("space")
    @Expose
    private var space: String? = null

    @SerializedName("network")
    @Expose
    private var network: String? = null

    @SerializedName("errors")
    @Expose
    private var errors: String? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getLoad(): String? {
        return load
    }

    fun setLoad(load: String?) {
        this.load = load
    }

    fun getSpace(): String? {
        return space
    }

    fun setSpace(space: String?) {
        this.space = space
    }

    fun getNetwork(): String? {
        return network
    }

    fun setNetwork(network: String?) {
        this.network = network
    }

    fun getErrors(): String? {
        return errors
    }

    fun setErrors(errors: String?) {
        this.errors = errors
    }
}