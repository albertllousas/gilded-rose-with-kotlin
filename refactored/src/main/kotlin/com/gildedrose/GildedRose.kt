package com.gildedrose

class GildedRose(private val items: List<Item>, private val itemAger: ItemAger = ItemAger()) {

    fun updateQuality() {
        items.forEach { item ->
            val agedItem = itemAger.ageOneDay(item)
            item.quality = agedItem.quality
            item.sellIn = agedItem.sellIn
        }
    }
}
