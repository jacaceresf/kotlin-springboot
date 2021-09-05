package dev.jacaceresf.springboot.kotlinwithspringboot.datasource.mock

import dev.jacaceresf.springboot.kotlinwithspringboot.datasource.BankDataSource
import dev.jacaceresf.springboot.kotlinwithspringboot.model.Bank
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.NoSuchElementException

@Repository
class MockBankDataSource : BankDataSource {

    private val banks = listOf(
        Bank("abcdef", 1.1, 1),
        Bank("1234", 17.1, 1),
        Bank(UUID.randomUUID().toString(), 0.0, 13)
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun getBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number: $accountNumber")
}