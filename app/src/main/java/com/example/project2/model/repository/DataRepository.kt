package com.example.project2.model.repository

import com.example.project2.model.entity.Animal
import com.example.project2.model.source.DataSource

object DataRepository {
    fun getAnimals(): List<Animal>{
        return DataSource.selectAnimals()
    }
}