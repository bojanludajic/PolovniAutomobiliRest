package com.bojanludajic.partsapi.service

import com.bojanludajic.partsapi.CarRequestDTO
import com.bojanludajic.partsapi.repository.PartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RestService(@Autowired private val pr: PartRepository) {

    fun getParts(request: CarRequestDTO) =
        pr.getPartByMakeAndAndModel(request.make, request.model)

    fun findPart(request: CarRequestDTO) =
        pr.findPart(request.make, request.model, request.name!!)

    fun orderPart(request: CarRequestDTO) {
        pr.orderPart(request.make, request.model, request.name!!)
    }

}