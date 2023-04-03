package dev.gelson.requestcreditsystem.service

import dev.gelson.requestcreditsystem.entity.Address
import dev.gelson.requestcreditsystem.entity.Customer
import dev.gelson.requestcreditsystem.repository.CustomerRepository
import dev.gelson.requestcreditsystem.service.impl.CustomerServices
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.*

@ActiveProfiles("teste")
@ExtendWith(MockKExtension::class)
class CustomerServiceTeste {
    @MockK
    lateinit var customerRepository: CustomerRepository

    @InjectMockKs
    lateinit var customerServices: CustomerServices

    @Test
    fun shouldCreateCustomer() {
        //given
        val fakeCustomer : Customer = builCustomer()
        every { customerRepository.save(any())} returns fakeCustomer

        //when
        val actual: Customer = customerServices.save(fakeCustomer)
        //then

        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify (exactly = 1 ) { customerRepository.save(fakeCustomer) }
    }


    @Test
    fun shoulfFindCostumerById(){
        val fakeId : Long = Random().nextLong()
        val fakeCustomer : Customer = builCustomer(id = fakeId)
        every{customerRepository.findById(fakeId)} returns Optional.of(fakeCustomer)

        val actual = customerServices.findById(fakeId)

        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isExactlyInstanceOf(Customer :: class.java)


    }



    private fun builCustomer(
        firstName: String = "Gelson",
        lastName: String = "Souza",
        cpf: String = "12345768",
        income: BigDecimal = BigDecimal.valueOf(10000.00),
        email: String = "gelson@gmail.com",
        password: String = "123456",
        zipCode: String = "7892321",
        street: String = "Rua Cesar R. Dos Santos",
        id: Long = 1L

    ) = Customer(
        firstName = firstName,
        lastName = lastName,
        cpf = cpf,
        income = income,
        email = email,
        password = password,
        address = Address(
            zipCode = zipCode,
            street = street
        ),
        id = id
    )


}