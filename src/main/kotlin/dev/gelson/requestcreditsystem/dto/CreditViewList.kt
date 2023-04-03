package dev.gelson.requestcreditsystem.dto

import dev.gelson.requestcreditsystem.entity.Credit
import java.math.BigDecimal
import java.util.*

data class CreditViewList (
    val creditCode : UUID,
    val creditValue : BigDecimal,
    val numberOfInstallments : Int
) {
    constructor(credit: Credit) : this (
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments
    )
}
