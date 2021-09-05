package dev.jacaceresf.springboot.kotlinwithspringboot.controller

import dev.jacaceresf.springboot.kotlinwithspringboot.model.Bank
import dev.jacaceresf.springboot.kotlinwithspringboot.service.BankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping
    fun getBanks(): Collection<Bank> = service.getBanks()

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable(value = "accountNumber") accountNumber: String): Bank = service.getBank(accountNumber)
}