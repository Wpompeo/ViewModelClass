package com.example.viewmodelapp

import androidx.lifecycle.ViewModel


class ClickCountViewModel : ViewModel() {

    private var count = 0

    fun getCount(): Int {
        return count
    }

    fun increment() {
        count += 1
    }

}