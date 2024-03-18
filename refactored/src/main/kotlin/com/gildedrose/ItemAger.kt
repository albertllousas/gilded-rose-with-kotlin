package com.gildedrose

data class AgedItem(val name: String, val sellIn: Int, val quality: Int)

class ItemAger(private val minQuality: Int = MIN_QUALITY, private val maxQuality: Int = MAX_QUALITY) {

    companion object {

        private const val AGED_BRIE = "Aged Brie"
        private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        private const val CONJURED = "Conjured Mana Cake"
        private const val MIN_QUALITY = 0
        private const val MAX_QUALITY = 50
    }

    fun ageOneDay(item: Item): AgedItem = when (item.name) {
        SULFURAS -> ageLegendaryItem(item)
        AGED_BRIE -> ageBrie(item)
        BACKSTAGE_PASSES -> ageBackstagePasses(item)
        CONJURED -> ageConjuredItem(item)
        else -> ageStandardItem(item)
    }

    private fun ageLegendaryItem(item: Item) = AgedItem(item.name, item.sellIn, item.quality)

    private fun ageBrie(item: Item) = (if (item.sellIn <= 0) item.quality + 2 else item.quality.inc())
        .coerceIn(minQuality, maxQuality)
        .let { AgedItem(item.name, item.sellIn.dec(), it) }

    private fun ageBackstagePasses(item: Item) = when {
        item.sellIn <= 0 -> 0
        item.sellIn <= 5 -> item.quality + 3
        item.sellIn <= 10 -> item.quality + 2
        else -> item.quality.inc()
    }.coerceIn(minQuality, maxQuality)
        .let { AgedItem(item.name, item.sellIn.dec(), it) }

    private fun ageStandardItem(item: Item) = (if (item.sellIn <= 0) item.quality - 2 else item.quality.dec())
        .coerceIn(minQuality, maxQuality)
        .let { AgedItem(item.name, item.sellIn.dec(), it) }

    private fun ageConjuredItem(item: Item) = (if (item.sellIn <= 0) item.quality -4 else item.quality - 2)
        .coerceIn(minQuality, maxQuality)
        .let { AgedItem(item.name, item.sellIn.dec(), it) }
}
