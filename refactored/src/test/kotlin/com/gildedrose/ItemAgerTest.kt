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

    @Test
    fun `should increase the quality of Aged Brie at the end of the day`() {
        val item = Item(name = "Aged Brie", sellIn = 10, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 21
    }

    @Test
    fun `should never increase the quality of an item above 50 at the end of the day`() {
        val item = Item(name = "Aged Brie", sellIn = 10, quality = 50)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 50
    }

    @Test
    fun `should increase the quality of Backstage passes at the end of the day`() {
        val item = Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 12, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 21
    }

    @Test
    fun `should increase by 2 the quality of Backstage passes 10 days or less before the concert`() {
        val item = Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 10, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 22
    }

    @Test
    fun `should increase by 4 the quality of Backstage passes 5 days or less before the concert`() {
        val item = Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 5, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 23
    }

    @Test
    fun `should lower the sellIn of an item at the end of the day`() {
        val item = Item(name = "Standard Item", sellIn = 10, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.sellIn shouldBe 9
    }

    @Test
    fun `should never lower the sellIn of a legendary item`() {
        val item = Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 10, quality = 80)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.sellIn shouldBe 10
    }

    @Test
    fun `should drop the quality to 0 of Backstage passes after the concert`() {
        val item = Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 0, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 0
    }

    @Test
    fun `should degrade quality twice as fast once the sell by date has passed`() {
        val item = Item(name = "Standard Item", sellIn = 0, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 18
    }

    @Test
    fun `should increase quality twice for aged Brie once the sell by date has passed`() {
        val item = Item(name = "Aged Brie", sellIn = 0, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 22
    }

    @Test
    fun `should lower the quality of a conjured item twice as standard ones`(){
        val item = Item(name = "Conjured Mana Cake", sellIn = 10, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 18
    }

    @Test
    fun `should lower quality twice for Conjured items once the sell by date has passed`(){
        val item = Item(name = "Conjured Mana Cake", sellIn = -1, quality = 20)

        val agedItem = itemAger.ageOneDay(item)

        agedItem.quality shouldBe 16
    }
}
