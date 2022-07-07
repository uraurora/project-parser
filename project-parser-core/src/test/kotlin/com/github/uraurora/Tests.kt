package com.github.uraurora

import org.junit.Assert.assertEquals


infix fun <T> T.shouldBe(other: T) {
    return assertEquals(this, other)
}