package org.gold.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.gold.mvvm.model.DataModel

class MainViewModel: ViewModel() {

    private val model = DataModel(UIText = "Hello Android Group")

    val uiTextLiveData=MutableLiveData<String>()

    fun getUpDatedText(){
        val updatedText = model.UIText
        uiTextLiveData.postValue(updatedText)
    }
}