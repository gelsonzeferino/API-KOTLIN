package dev.gelson.requestcreditsystem.service

import dev.gelson.requestcreditsystem.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit : Credit) : Credit

    fun findAllByCustomer(customerId : Long) : List<Credit>

    fun findByCreditCode(customerId: Long, creditCode : UUID) : Credit
}