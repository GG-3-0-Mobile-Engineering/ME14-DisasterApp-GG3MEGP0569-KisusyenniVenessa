package com.kisusyenni.disasterapp.data.repository

import com.kisusyenni.disasterapp.data.api.ApiService
import com.kisusyenni.disasterapp.data.api.ReportsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DisasterAppRepositoryImpl @Inject constructor(private val api: ApiService): DisasterAppRepository {
    override fun getFloodGauges() = flow {
        val data = api.getFloodGauges()
        emit(data)
    }.flowOn(Dispatchers.IO)
    override fun getReports(disaster: String): Flow<ReportsResponse> = flow {
        val data = api.getReports(disaster = disaster)
        emit(data)
    }.flowOn(Dispatchers.IO)

    override fun getReports(disaster: String, admin: String): Flow<ReportsResponse> = flow {
        val data = api.getReports(disaster = disaster, admin = admin)
        emit(data)
    }.flowOn(Dispatchers.IO)
}