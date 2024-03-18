package com.gildedrose

data class AgedItem(val name: String, val sellIn: Int, val quality: Int)

class ItemAger {

    companion object {

        private const val AGED_BRIE = "Aged Brie"
        private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        private const val MIN_QUALITY = 0
        private const val MAX_QUALITY = 50
    }

    fun ageOneDay(item: Item): AgedItem = when (item.name) {
        SULFURAS -> AgedItem(item.name, item.sellIn, item.quality)
        AGED_BRIE -> ageBrie(item)
        BACKSTAGE_PASSES -> ageBackstagePasses(item)
        else -> ageStandardItem(item)
    }

    private fun ageBrie(item: Item) = (if (item.sellIn <= 0) item.quality + 2 else item.quality.inc())
        .coerceIn(MIN_QUALITY, MAX_QUALITY)
        .let { AgedItem(item.name, item.sellIn.dec(), it) }

    private fun ageBackstagePasses(item: Item) = when {
        item.sellIn <= 0 -> 0
        item.sellIn <= 5 -> item.quality + 3
        item.sellIn <= 10 -> item.quality + 2
        else -> item.quality.inc()
    }.coerceIn(MIN_QUALITY, MAX_QUALITY)
        .let { AgedItem(item.name, item.sellIn.dec(), it) }

    private fun ageStandardItem(item: Item) = (if (item.sellIn <= 0) item.quality - 2 else item.quality.dec())
        .coerceIn(MIN_QUALITY, MAX_QUALITY)
        .let { AgedItem(item.name, item.sellIn.dec(), it) }
}
