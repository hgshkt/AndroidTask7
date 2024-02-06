package com.hgshkt.androidtask7.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hgshkt.androidtask7.model.NumberModel
import com.hgshkt.androidtask7.model.NumberModelImpl

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val model: NumberModel = NumberModelImpl(application)
    val numberLiveData = MutableLiveData(model.get())

    fun add(){
        model.add()
        numberLiveData.value = model.get()
    }
}