package com.javabom.api.domain.mining.controller

import com.javabom.api.domain.mining.dto.MiningCreateRequest
import com.javabom.api.domain.mining.dto.MiningDto
import com.javabom.api.domain.mining.facade.MiningFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/mining")
class MiningController(
    val facade: MiningFacade,
) {
    @PostMapping("/{memberNumber}")
    fun createMining(
        @PathVariable("memberNumber") memberNumber: String,
        @RequestBody request: MiningCreateRequest,
    ): ResponseEntity<MiningDto> {
        val dto = facade.createMining(memberNumber, request)

        return ResponseEntity.created(URI.create("/mining/${dto.id}")).body(dto)
    }

    @DeleteMapping("/{memberNumber}")
    fun deleteMining(@PathVariable("memberNumber") memberNumber: String): ResponseEntity<Nothing> {
        facade.deleteMining(memberNumber)
        return ResponseEntity.ok().build()
    }
}
