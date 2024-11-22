package com.maraloedev.ejemplo010_datos_de_fragment_a_activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 3ª forma de pasar datos de Fragment a Activity
class Dato : ViewModel() {
    var dato  = MutableLiveData<String>()
}