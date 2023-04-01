package dev.gelson.requestcreditsystem.service.impl

import dev.gelson.requestcreditsystem.entity.Customer
import dev.gelson.requestcreditsystem.repository.CustomerRepository
import dev.gelson.requestcreditsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerServices(private val customerRepository: CustomerRepository) : ICustomerService {
    override fun save(customer : Customer) : Customer =
        this.customerRepository.save(customer)


    override fun findById(id : Long) : Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException("Id $id not found")
        }


    override fun delete(id : Long) =
        this.customerRepository.deleteById(id)

}