package com.anushka.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalData: LiveData<Int>
        get() = total

    var input = MutableLiveData<String>()

    init {
        total.value = startingTotal
    }

    fun setTotal() {
        val intInput = input.value?.toInt() ?: 0
        total.value = total.value?.plus(intInput)
    }
}