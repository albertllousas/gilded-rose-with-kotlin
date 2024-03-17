package com.gildedrose

data class AgedItem(val name: String, val sellIn: Int, val quality: Int)

class ItemAger {

    companion object {

        private const val AGED_BRIE_ITEM_NAME = "Aged Brie"

        private const val SULFURAS_ITEM_NAME = "Sulfuras, Hand of Ragnaros"

        private const val BACKSTAGE_PASSES_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert"
    }

    fun ageOneDay(item: Item): AgedItem {
        val (name, sellIn, quality) = item
        if (item.isLegendary()) return AgedItem(name, sellIn, quality)
        val newQuality = when (name) {
            AGED_BRIE_ITEM_NAME -> quality.inc()
            BACKSTAGE_PASSES_ITEM_NAME ->
                if (sellIn <= 0) 0
                else if (sellIn <= 5) quality + 3
                else if (sellIn <= 10) quality + 2
                else quality.inc()

            else -> quality.dec()
        }.coerceIn(0, 50)
        val newSellIn = sellIn.dec()
        return AgedItem(name, newSellIn, newQuality)
    }

    private fun Item.isLegendary() = this.name == SULFURAS_ITEM_NAME
}

private operator fun Item.component1() = this.name

private operator fun Item.component2() = this.sellIn

private operator fun Item.component3() = this.quality
