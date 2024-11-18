package com.anushka.viewmodeldemo1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel(startingTotal: Int): ViewModel() {
    //양방향 작업할 때 코드 수정
    private var _total = MutableLiveData<Int>()
    val total: MutableLiveData<Int>
        get() = _total

    val inputText = MutableLiveData<String>()

    init {
        _total.value = startingTotal
    }

    fun setTotal(){
        _total.value = _total.value?.plus(inputText.value!!.toInt())
    }
}