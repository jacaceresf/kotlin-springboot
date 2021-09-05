package dev.jacaceresf.springboot.kotlinwithspringboot.controller

import dev.jacaceresf.springboot.kotlinwithspringboot.model.Bank
import dev.jacaceresf.springboot.kotlinwithspringboot.service.BankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @GetMapping
    fun getBanks(): Collection<Bank> = service.getBanks()

}