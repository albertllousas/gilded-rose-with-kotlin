package com.gildedrose

data class AgedItem(val name: String, val sellIn: Int, val quality: Int)

class ItemAger {

    companion object {

        private const val SULFURAS_ITEM_NAME = "Sulfuras, Hand of Ragnaros"
    }

    fun ageOneDay(item: Item): AgedItem {
        val (name, sellIn, quality) = item
        val newQuality = if(name != SULFURAS_ITEM_NAME) (quality - 1).coerceAtLeast(0) else quality
        return AgedItem(name, sellIn, newQuality)
    }
}

private operator fun Item.component1() = this.name

private operator fun Item.component2() = this.sellIn

private operator fun Item.component3() = this.quality
