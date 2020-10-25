package com.cleantool.indiacleantool.database.dao

import androidx.room.*
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceRequest

@Dao
interface ServiceRequestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg  serviceRequest: ServiceRequest) : LongArray

    @Query("SELECT * from servicerequest")
    fun getAll() : List<ServiceRequest>


    @Delete
    fun delete(serviceRequest: ServiceRequest)

}