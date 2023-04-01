package dev.gelson.requestcreditsystem.service

import dev.gelson.requestcreditsystem.entity.Customer

interface ICustomerService {

    fun save (customer: Customer)  : Customer

    fun findById (id : Long) : Customer

    fun delete(id : Long)

}