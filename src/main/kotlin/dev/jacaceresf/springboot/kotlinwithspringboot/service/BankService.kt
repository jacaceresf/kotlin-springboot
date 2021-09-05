package dev.jacaceresf.springboot.kotlinwithspringboot.service

import dev.jacaceresf.springboot.kotlinwithspringboot.datasource.BankDataSource
import dev.jacaceresf.springboot.kotlinwithspringboot.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()

}