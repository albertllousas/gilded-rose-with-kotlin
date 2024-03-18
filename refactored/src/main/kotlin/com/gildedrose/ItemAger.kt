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
        SULFURAS -> AgedItem(item.name, item.sellIn, item.quality)
        AGED_BRIE -> age(item, whenExpired = { it.quality + 2 }, otherwise = { it.quality.inc() })
        BACKSTAGE_PASSES -> ageBackstagePasses(item)
        CONJURED -> age(item, whenExpired = { it.quality - 4 }, otherwise = { it.quality - 2 })
        else -> age(item, whenExpired = { it.quality - 2 }, otherwise = { it.quality - 1 })
    }

    private fun ageBackstagePasses(item: Item) = age(
        item,
        whenExpired = { 0 },
        otherwise = { if (item.sellIn <= 5) item.quality + 3 else if (item.sellIn <= 10) item.quality + 2 else item.quality + 1 }
    )

    private fun age(item: Item, whenExpired: (Item) -> Int, otherwise: (Item) -> Int) =
        (if (item.sellIn <= 0) whenExpired(item) else otherwise(item))
            .coerceIn(minQuality, maxQuality)
            .let { newQuality -> AgedItem(item.name, item.sellIn.dec(), newQuality) }
}
