package com.bojanludajic.partsapi.controller

import com.bojanludajic.partsapi.CarRequestDTO
import com.bojanludajic.partsapi.service.RestService
import jakarta.validation.Valid
import model.Part
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class PartsRestController(@Autowired private val service: RestService) {

    @GetMapping("/partsForModel")
    fun partsForModel(@RequestBody @Valid request: CarRequestDTO): ResponseEntity<*> {
        val parts = service.getParts(request)
        if(parts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nema delova za ovaj auto!")
        }

        return ResponseEntity.ok(parts)
    }

    @PatchMapping("/order")
    fun orderPart(@RequestBody @Valid request: CarRequestDTO): ResponseEntity<*> {
        val part = service.findPart(request)

        if(part == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nije pronadjen taj teo.")
        }

        if(part.availability == 0) {
            return ResponseEntity.badRequest()
                .body("Ovaj deo nije dostupan!")
        }

        try {
            service.orderPart(request)
            return ResponseEntity.ok("Uspesno ste porucili deo!")
        } catch (e: Exception) {
            e.printStackTrace()
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Doslo je do greske, pokusajte ponovo kasnije.")
        }
    }

}