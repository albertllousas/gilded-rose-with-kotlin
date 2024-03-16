package com.gildedrose

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ItemAgerTest {

    private val itemAger = ItemAger()

    @Test
    fun `should lower quality of a standard item at the end of the day`() {
        val item = Item(name = "Standard Item", sellIn = 10, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 19
    }
}
