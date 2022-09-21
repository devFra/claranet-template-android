package net.clara.it.claranet_template_android


import androidx.lifecycle.ProcessLifecycleOwner.get
import androidx.lifecycle.viewmodel.compose.viewModel
import net.clara.it.claranet_template_android.api.ApiService
import net.clara.it.claranet_template_android.screen.home.HomeScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
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

val viewModelModule = module {
    viewModel{ HomeScreenViewModel() }
}