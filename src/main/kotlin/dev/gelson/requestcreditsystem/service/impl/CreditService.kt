package dev.gelson.requestcreditsystem.service.impl

import dev.gelson.requestcreditsystem.CreditRepository
import dev.gelson.requestcreditsystem.entity.Credit
import dev.gelson.requestcreditsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerServices
) : ICreditService {
    override fun save(credit: Credit): Credit {

        credit.apply {
            var customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findByCustomer(customerId)

    override fun findByCreditCode(customerId: Long,creditCode: UUID): Credit {
        val credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Creditcode $creditCode not found")

        return  if(credit.customer?.id == customerId) credit else throw RuntimeException ("Contact admin")
    }
}