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
        val newQuality = when (name) {
            SULFURAS_ITEM_NAME -> quality
            AGED_BRIE_ITEM_NAME -> quality.inc().coerceIn(0, 50)
            BACKSTAGE_PASSES_ITEM_NAME -> quality.inc().coerceIn(0, 50)
            else -> quality.dec().coerceIn(0, 50)
        }
        return AgedItem(name, sellIn, newQuality)
    }
}

private operator fun Item.component1() = this.name

private operator fun Item.component2() = this.sellIn

private operator fun Item.component3() = this.quality
