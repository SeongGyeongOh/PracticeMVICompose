package com.osg.practicemvicomposenav.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.osg.practicemvicomposenav.data.ApiHelper
import com.osg.practicemvicomposenav.repository.MainRepository
import com.osg.practicemvicomposenav.viewstate.MainViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    @InternalCoroutinesApi
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("unknown class")
    }
}
