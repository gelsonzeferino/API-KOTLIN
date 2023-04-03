package dev.gelson.requestcreditsystem.controller

import dev.gelson.requestcreditsystem.dto.CostumerUpdateDto
import dev.gelson.requestcreditsystem.dto.CustomerDTO
import dev.gelson.requestcreditsystem.dto.CustomerView
import dev.gelson.requestcreditsystem.service.impl.CustomerServices
import org.hibernate.sql.Update
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerResource(private val customerServices: CustomerServices) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDTO: CustomerDTO): ResponseEntity<CustomerView> {
        val savedCustomer = this.customerServices.save(customerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerView(savedCustomer))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer = this.customerServices.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerServices.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody customerUpdateDto: CostumerUpdateDto
    ): ResponseEntity<CustomerView> {
        val customer = this.customerServices.findById(id)
        val customerToUpdate = customerUpdateDto.toEntity(customer)
        val customerUpdated = this.customerServices.save(customerToUpdate)

        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }

}