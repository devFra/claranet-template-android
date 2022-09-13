package net.clara.it.claranet_template_android


import net.clara.it.claranet_template_android.api.ApiService
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit


val networkModule = module {

    single(named("apiService") ) {
        Retrofit.Builder()
            .client(get())
            .baseUrl(androidApplication().getString(R.string.backend_base_url))
            .build()
            .create(ApiService::class.java)
    }
}