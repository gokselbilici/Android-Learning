package com.example.myweatherapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myweatherapp.data.db.entity.CURRENT_WEATHER_ID
import com.example.myweatherapp.data.db.entity.CurrentWeatherEntry
import com.example.myweatherapp.data.db.unitlocalized.MetricCurrentWeatherEntry
import com.example.myweatherapp.data.db.unitlocalized.SpecificCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric():LiveData<MetricCurrentWeatherEntry>

}