package com.cleantool.indiacleantool.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cleantool.indiacleantool.database.dao.ServiceRequestDao
import com.cleantool.indiacleantool.models.networkmodels.bookservice.ServiceRequest

@Database(entities = arrayOf(ServiceRequest::class),version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun serviceRequestDao() : ServiceRequestDao
}