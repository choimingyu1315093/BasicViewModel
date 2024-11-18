package com.anushka.viewmodeldemo1

import androidx.lifecycle.ViewModel

class MainViewModel(startingTotal: Int): ViewModel() {
    private var total = 0

    init {
        total = startingTotal
    }

    fun getTotal(): Int {
        return total
    }

    fun setTotal(input: Int){
        total += input
    }
}