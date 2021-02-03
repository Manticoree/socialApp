package com.app.socialapp.mvvm.serials.fragment.topserial

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.socialapp.domain.entities.ItemManyHolderTopMovies
import com.app.socialapp.domain.repository.remote.tmdb.TopSerialsRepository
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TopSerialViewModel : ViewModel() {
    private val topSerialsRepository = TopSerialsRepository()
    var serialsData: MutableList<ItemManyHolderTopMovies>? = mutableListOf()
    var serialsLiveData: MutableLiveData<MutableList<ItemManyHolderTopMovies>>? = MutableLiveData()

    val isLoadingProgressBar: ObservableBoolean = ObservableBoolean(false)

    private var vmJob = Job()
    val vmScope = CoroutineScope(Dispatchers.IO + vmJob)

    lateinit var disTopSerials: Disposable

    fun loadDataInRecView() {
        vmScope.launch {
            isLoadingProgressBar.set(true)
            serialsData?.add(topSerialsRepository.getTopSerials())?.let {
                isLoadingProgressBar.set(false)
                serialsLiveData?.postValue(serialsData)
            }
        }
    }

    fun clearSession() {
        disTopSerials.dispose()
    }
}