package dev.gelson.requestcreditsystem.entity

import dev.gelson.requestcreditsystem.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
data class Credit(
    @Column(nullable = false) val creditCode: UUID,
    @Column(nullable = false) val creditValue: BigDecimal,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstallments: Int,
    @Enumerated val status: Status,
    @ManyToOne var customer: Customer,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)