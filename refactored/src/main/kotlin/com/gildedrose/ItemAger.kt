package com.gildedrose

data class AgedItem(val name: String, val sellIn: Int, val quality: Int)

class ItemAger {

    fun ageOneDay(item: Item): AgedItem {
        val (name, sellIn, quality) = item
        return AgedItem(name, sellIn, quality -  1)
    }

}

private operator fun Item.component1() = this.name

private operator fun Item.component2() = this.sellIn

private operator fun Item.component3() = this.quality
