package dev.jacaceresf.springboot.kotlinwithspringboot.service

import dev.jacaceresf.springboot.kotlinwithspringboot.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val dataSource: BankDataSource =
        mockk(relaxed = true) ///it always returns something so we don't need to define a behavior.

    private val bankService = BankService(dataSource)

    @Test
    fun `should call its data source to retrieve banks`() {
        /// given
        /// since the datasource is a mock, we've got to define its behavior before call any method.
        ///       every { dataSource.retrieveBanks() } returns emptyList()

        /// when
        val banks = bankService.getBanks()
        /// then
        verify(exactly = 1) { dataSource.retrieveBanks() } ///checks if the service actually called to the repository function.
    }

}