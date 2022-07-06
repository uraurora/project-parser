package com.github.uraurora.projectparser.resolver.utils

import com.github.uraurora.projectparser.resolver.utils.DatetimeConstants.Companion.OFFSET
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class DatetimeConstants{
    companion object{
        val OFFSET: ZoneOffset = ZoneOffset.of("+8")
    }
}

fun Date.asLocalDate(): LocalDate{
    return Instant.ofEpochMilli(this.time).atZone(DatetimeConstants.OFFSET).toLocalDate()
}

fun Date.asLocalDateTime(): LocalDateTime{
    return Instant.ofEpochMilli(this.time).atZone(DatetimeConstants.OFFSET).toLocalDateTime()
}

fun LocalDateTime.asDate(): Date{
    return Date.from(this.atZone(DatetimeConstants.OFFSET).toInstant())
}

fun LocalDate.asDate(): Date{
    return Date.from(this.atStartOfDay().atZone(DatetimeConstants.OFFSET).toInstant())
}

fun now(): LocalDateTime {
    return LocalDateTime.now(OFFSET)
}

fun nowDate(): Date? {
    return now().asDate()
}


