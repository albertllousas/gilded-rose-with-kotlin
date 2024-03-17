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

    @Test
    fun `should never lower quality of an item below 0 at the end of the day`() {
        val item = Item(name = "Standard Item", sellIn = 10, quality = 0)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 0
    }

    @Test
    fun `should never lower the quality of a legendary item`() {
        val item = Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 10, quality = 80)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 80
    }
}
