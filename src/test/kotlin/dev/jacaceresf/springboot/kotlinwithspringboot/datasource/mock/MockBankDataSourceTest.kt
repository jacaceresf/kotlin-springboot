package dev.jacaceresf.springboot.kotlinwithspringboot.datasource.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.NoSuchElementException

internal class MockBankDataSourceTest {

    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks`() {
        /// when
        val banks = mockDataSource.retrieveBanks()
        /// then -> for assertions
        Assertions.assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`() {
        /// when
        val banks = mockDataSource.retrieveBanks()
        /// then
        Assertions.assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        Assertions.assertThat(banks).allMatch { it.trust != 0.0 }
        Assertions.assertThat(banks).allMatch { it.transactionFee != 0 }
    }

    @Test
    fun `should provide a bank by given account number`() {
        /// given
        val accountNumber = "1234"
        /// when
        val bank = mockDataSource.getBank(accountNumber)
        /// then
        Assertions.assertThat(bank).isNotNull
    }

    @Test
    fun `should return an exception`() {
        Assertions.assertThatThrownBy { mockDataSource.getBank("not_found_account") }.isInstanceOfAny(
            NoSuchElementException::class.java
        )
    }
}