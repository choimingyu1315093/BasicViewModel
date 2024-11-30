package com.anushka.viewmodeldemo1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(startingTotal: Int): ViewModel() {
    //LiveData 안 씀
//    private var total = 0
//
//    init {
//        total = startingTotal
//    }
//
//    fun getTotal(): Int {
//        return total
//    }
//
//    fun setTotal(input: Int){
//        total += input
//    }


    //LiveData는 데이터의 변화를 감지하고 UI에 전송하는 역할(자동으로 반영)
//    private var _total = MutableLiveData<Int>()
//    val total: MutableLiveData<Int>
//        get() = _total
//
//    init {
//        _total.value = startingTotal
//    }
//
//    fun setTotal(input: Int){
//        _total.value = _total.value?.plus(input)
//    }

    //StateFlow 사용할 때
    private var _total = MutableStateFlow<Int>(0)
    val total: StateFlow<Int>
        get() = _total

    init {
        _total.value = startingTotal
    }

    fun setTotal(input: Int){
        _total.value = _total.value.plus(input)
    }
}