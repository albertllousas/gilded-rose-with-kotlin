package com.gildedrose

import org.approvaltests.Approvals
import org.junit.jupiter.api.Test

class GildedRoseApprovalTest {

    private val items = listOf(
        Item("+5 Dexterity Vest", 10, 20), //
        Item("Aged Brie", 2, 0), //
        Item("Elixir of the Mongoose", 5, 7), //
        Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        Item("Sulfuras, Hand of Ragnaros", -1, 80),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
    )
    private val gildedRose = GildedRose(items)

    @Test
    fun `should update the inventory for 10 days`() {
        Approvals.verifyAll("Days", (0..9)) { day ->
            """-------- day $day --------${'\n'}name, sellIn, quality${'\n'}${items.joinToString("\n")}""".trimIndent()
                .also {  gildedRose.updateQuality() }
        }
    }
}
