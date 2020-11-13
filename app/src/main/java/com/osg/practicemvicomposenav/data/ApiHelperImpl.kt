package com.osg.practicemvicomposenav.data

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getData(): PharmacyElement {
        return apiService.getData()
    }
}
