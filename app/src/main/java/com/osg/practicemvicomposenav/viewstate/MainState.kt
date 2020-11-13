package com.osg.practicemvicomposenav.viewstate

import com.osg.practicemvicomposenav.data.PharmacyElement

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class Pharmacy(val pharmacyItem: PharmacyElement) : MainState()
    data class Error(val error: String) : MainState()
}
