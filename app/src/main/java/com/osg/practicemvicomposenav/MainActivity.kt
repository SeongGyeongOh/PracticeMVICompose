package com.osg.practicemvicomposenav

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.ui.tooling.preview.Preview
import com.osg.practicemvicomposenav.data.ApiHelperImpl
import com.osg.practicemvicomposenav.data.PharmacyElement
import com.osg.practicemvicomposenav.data.apiService
import com.osg.practicemvicomposenav.intent.MainIntent
import com.osg.practicemvicomposenav.ui.PracticeMVIComposeNavTheme
import com.osg.practicemvicomposenav.util.ViewModelFactory
import com.osg.practicemvicomposenav.viewstate.MainState
import com.osg.practicemvicomposenav.viewstate.MainViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel:MainViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelperImpl(apiService))).get(MainViewModel::class.java)

        setContent {
            PracticeMVIComposeNavTheme {
                viewModel.viewModelScope.launch {
                    viewModel.userIntent.send(MainIntent.FetchData)
                }
                MainScreen(viewModel)
            }
        }
    }
}

@InternalCoroutinesApi
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val currentState by viewModel.state.observeAsState("")
    when(currentState){
        is MainState.Idle -> {}
        is MainState.Loading -> {
            LoadingScreen()
        }
        is MainState.Pharmacy -> {
            val element = (currentState as MainState.Pharmacy).pharmacyItem
            PharmacyList(element)
        }
        is MainState.Error ->{
            ErrorScreen()
        }
    }

}

@Composable
fun LoadingScreen(){
//    Column() {
//        CircularProgressIndicator(modifier = Modifier.wrapContentWidth())
//    }
}

@InternalCoroutinesApi
@Composable
fun PharmacyList(
    element: PharmacyElement
){
    Log.i("element", element.toString())

}

@Composable
fun ErrorScreen(){

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PracticeMVIComposeNavTheme {
    }
}
