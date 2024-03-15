package com.gildedrose

class GildedRose(private val items: List<Item>) {

    companion object {

        private const val BACKSTAGE_PASSES_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert"

        private const val AGED_BRIE_ITEM_NAME = "Aged Brie"

        private const val SULFURAS_ITEM_NAME = "Sulfuras, Hand of Ragnaros"
    }

    fun updateQuality() {
        items.forEach {  item ->
            if (item.name != AGED_BRIE_ITEM_NAME && item.name != BACKSTAGE_PASSES_ITEM_NAME) {
                if (item.quality > 0) {
                    if (item.name != SULFURAS_ITEM_NAME) {
                        item.quality -= 1
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality += 1

                    if (item.name == BACKSTAGE_PASSES_ITEM_NAME) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality += 1
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality += 1
                            }
                        }
                    }
                }
            }

            if (item.name != SULFURAS_ITEM_NAME) {
                item.sellIn -= 1
            }

            if (item.sellIn < 0) {
                if (item.name != AGED_BRIE_ITEM_NAME) {
                    if (item.name != BACKSTAGE_PASSES_ITEM_NAME) {
                        if (item.quality > 0) {
                            if (item.name != SULFURAS_ITEM_NAME) {
                                item.quality -= 1
                            }
                        }
                    } else {
                        item.quality -= item.quality
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality += 1
                    }
                }
            }
        }
    }

}

