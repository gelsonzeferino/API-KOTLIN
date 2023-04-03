package dev.gelson.requestcreditsystem.dto

import dev.gelson.requestcreditsystem.Status
import dev.gelson.requestcreditsystem.entity.Credit
import dev.gelson.requestcreditsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditDto (
    val creditValue : BigDecimal,
    val dayFirstOfInstallment : LocalDate,
    val numberOfInstallments : Int,
    val customerId : Long,

) {


    fun toEntity() : Credit = Credit(

        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)

    )
}
