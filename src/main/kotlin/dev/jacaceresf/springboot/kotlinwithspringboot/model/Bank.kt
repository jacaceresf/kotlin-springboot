package dev.jacaceresf.springboot.kotlinwithspringboot.model

data class Bank(
    val accountNumber: String,
    val trust: Double,
    val transactionFee: Int
)