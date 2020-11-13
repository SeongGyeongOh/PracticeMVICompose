package com.osg.practicemvicomposenav.repository

import com.osg.practicemvicomposenav.data.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getData() = apiHelper.getData()
}
