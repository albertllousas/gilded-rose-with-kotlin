package com.gildedrose

data class AgedItem(val name: String, val sellIn: Int, val quality: Int)

class ItemAger {

    companion object {

        private const val AGED_BRIE_ITEM_NAME = "Aged Brie"

        private const val SULFURAS_ITEM_NAME = "Sulfuras, Hand of Ragnaros"

        private const val BACKSTAGE_PASSES_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert"
    }

    fun ageOneDay(item: Item): AgedItem {
        if (item.isLegendary()) return AgedItem(item.name, item.sellIn, item.quality)
        val newQuality = when (item.name) {
            AGED_BRIE_ITEM_NAME -> if (item.sellIn <= 0) item.quality + 2 else item.quality.inc()
            BACKSTAGE_PASSES_ITEM_NAME ->
                if (item.sellIn <= 0) 0
                else if (item.sellIn <= 5) item.quality + 3
                else if (item.sellIn <= 10) item.quality + 2
                else item.quality.inc()

            else -> if (item.sellIn <= 0) item.quality - 2 else item.quality.dec()
        }.coerceIn(0, 50)
        val newSellIn = item.sellIn.dec()
        return AgedItem(item.name, newSellIn, newQuality)
    }

    private fun Item.isLegendary() = this.name == SULFURAS_ITEM_NAME
}
