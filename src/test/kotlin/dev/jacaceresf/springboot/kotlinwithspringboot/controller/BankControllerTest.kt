package dev.jacaceresf.springboot.kotlinwithspringboot.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest /// this will initialize the entire application context. It is expensive.
@AutoConfigureMockMvc
internal class BankControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc ///it allows to execute request to the API.

    @Test
    fun `should return all banks`() {

        /// when/then
        mockMvc.get("/api/banks")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].accountNumber") { value("abcdef") }
            }
    }
}