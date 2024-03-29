package com.echo.careaxiomtest2.ui.adapter.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.android.careaxiomtest.MainApp
import com.android.careaxiomtest.network.NetworkService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PhotoDataSourceFactory constructor(
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Long, Any>() {


    @Inject
    lateinit var networkService: NetworkService

    val photoDSLive = MutableLiveData<PhotoDataSource>()

    init {
        MainApp.appCompnent.inject(this)
    }

    override fun create(): DataSource<Long, Any> {
        // Log.i("PDSF", "onCreate")

        val dataSource = PhotoDataSource(
            compositeDisposable,
            networkService = networkService
        )
        photoDSLive.postValue(dataSource)
        return dataSource
    }


}
