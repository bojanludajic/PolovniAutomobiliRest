package com.bojanludajic.partsapi.repository

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository

import model.Part
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PartRepository : JpaRepository<Part, Int> {

    fun getPartByMakeAndAndModel(make: String, model: String): List<Part>

    @Query("Select p from Part p where p.make = :x and p.model = :y and p.name = :z")
    fun findPart(@Param(value="x") make: String,
                 @Param(value="y") model: String,
                 @Param(value="z") name: String): Part?

    @Modifying
    @Transactional
    @Query("Update Part p set p.availability = p.availability - 1 where p.make = :x" +
            " and p.model = :y and p.name = :z")
    fun orderPart(@Param(value="x") make: String,
                  @Param(value="y") model: String,
                  @Param(value="z") name: String)

}