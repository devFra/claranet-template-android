package net.clara.it.claranet_template_android.repository

import android.app.Application
import net.clara.it.claranet_template_android.api.ApiService

class Repository (
    private val application: Application,
    private val apiService: ApiService
){
    fun getItems(): Any {
        return apiService.getItems()
    }
}