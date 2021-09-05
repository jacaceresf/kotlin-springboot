package dev.jacaceresf.springboot.kotlinwithspringboot.datasource

import dev.jacaceresf.springboot.kotlinwithspringboot.model.Bank

interface BankDataSource {

    /**
     *Returns a collection of banks.
     */
    fun retrieveBanks(): Collection<Bank>

    fun getBank(accountNumber: String): Bank

}