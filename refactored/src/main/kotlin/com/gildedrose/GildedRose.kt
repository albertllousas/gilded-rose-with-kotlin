package com.gildedrose

class GildedRose(private val items: List<Item>, private val itemAger: ItemAger = ItemAger()) {

    companion object {

        private const val AGED_BRIE_ITEM_NAME = "Aged Brie"

    }

    fun updateQuality() {
        items.forEach { item ->
            val agedItem = itemAger.ageOneDay(item)
            item.quality = agedItem.quality
            item.sellIn = agedItem.sellIn

            if (item.sellIn < 0) {
                if (item.name == AGED_BRIE_ITEM_NAME) {
                    if (item.quality < 50) {
                        item.quality += 1
                    }
                }
            }
        }
    }

}

