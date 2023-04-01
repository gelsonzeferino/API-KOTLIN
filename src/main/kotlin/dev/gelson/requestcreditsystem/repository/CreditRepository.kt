package dev.gelson.requestcreditsystem

import dev.gelson.requestcreditsystem.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository : JpaRepository <Credit, Long>
