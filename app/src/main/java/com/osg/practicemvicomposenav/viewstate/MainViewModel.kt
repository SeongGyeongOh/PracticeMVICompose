package com.osg.practicemvicomposenav.viewstate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osg.practicemvicomposenav.intent.MainIntent
import com.osg.practicemvicomposenav.repository.MainRepository
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
    private val _state = MutableLiveData<MainState>()
    val state: LiveData<MainState> get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MainIntent.FetchData -> fetchData()
                }
            }
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.Pharmacy(repository.getData())
            } catch (e: Exception) {
                MainState.Error(e.message.toString())
            }
        }
    }
}
