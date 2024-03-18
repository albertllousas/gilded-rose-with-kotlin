# Gilded rose kata in kotlin

Original source: https://github.com/emilybache/GildedRose-Refactoring-Kata

## Requirements Specification

[requirements](requirements.md)

## Steps-followed

1. Understand requirements
2. Write [characterization tests](https://en.wikipedia.org/wiki/Characterization_test), a safety net of test for our legacy code. In our case, we have used https://approvaltests.com/, check [here](refactored/src/test/kotlin/com/gildedrose/ApprovalTest.kt)
3. Make sure our approval tests are passing
4. Perform refactor on the legacy code ( [GildedRose](refactored/src/main/kotlin/com/gildedrose/GildedRose.kt) class) or any new code created during the process ([ItemAger](refactored/src/main/kotlin/com/gildedrose/ItemAger.kt)), go to 3 till we are done
5. Extract code to a different class (in our case ItemAger class) **using TDD**
   - Identify code for extraction 
   - Apply TDD cycle
      - Write a failing test
      - Write the minimum code to pass the test 
      - Refactor
   - Integrate the new code in the legacy code
6. Come back to 3 till we are done
7. **Use TDD** to add new features (in our case Conjured items)

### Detailed steps

```shell
$> glog
* 6d00947 Small refactor on ItemAger: Remove specific functions and use 'age' generic one instead
* c2a0f3d Small refactor on ItemAger: Format lines and introduce variable for more legibility
* bcfdba5 Refactor on ItemAger: introduce 'ageItem' generic function
* 0e62af6 Add scenario to ItemAger: lower quality twice for Conjured items once the sell by date has passed
* 4eb7cbe Add scenario to ItemAger: lower the quality of a conjured item twice as standard ones
* fba8094 Small refactor on ItemAger: Add ageLegendaryItem method for consistency
* 35ef49f Small refactor on ItemAger: provide min max in construction time
* 542e485 Refactor on ItemAger: extract age logic in different aging methods
* f000867 Small refactor on ItemAger: extract min max quality magic numbers to constants
* 5719e6b Small refactor on ItemAger: use Item instead of its properties
* 01ba1b5 Refactor on GildedRose: Remove remaining legacy code
* d7e0cb7 Add scenario to ItemAger: increase quality twice for aged Brie once the sell by date has passed
* 77825ee Refactor on GildedRose: Integrate ItemAger new code for degrading quality twice
* c7083ce Add scenario to ItemAger: degrade quality twice as fast once the sell by date has passed
* 39c21d9 Refactor on GildedRose: Integrate ItemAger new code for backstage quality adter the concert
* a74bf90 Add scenario to ItemAger: drop the quality to 0 of Backstage passes after the concert
* 0f4d227 Add scenario to ItemAger: lower the sellIn of an item at the end of the day
* 6779cd7 Add scenario to ItemAger: increase by 3 the quality of Backstage passes 5 days or less before the concert
* ef7f6ab Refactor on GildedRose: Integrate ItemAger for quality increasement
* 49ed676 Add scenario to ItemAger: increase the quality of Backstage passes at the end of the day
* b15020d Add scenario to ItemAger: never increase the quality of an item above 50
* 4034ffd Add scenario to ItemAger: increase the quality of Aged Brie at the end of the day
* 93a85c3 Refactor on GildedRose: Integrate ItemAger for quality decreasement
* 68ff6f7 Add scenario to ItemAger: never lower the quality of a legendary item
* b76d5e8 Add scenario to ItemAger: never lower quality of an item below 0 at the end of the day
* ee22a12 Introduce ItemAger class and first scenario: lower quality of a standard item at the end of the day
* c06adab Refactor on GildedRose: change for loop by forEach idiomatic kotlin
* 1a2c47b Refactor on GildedRose: extract item names as constants in the class
* 7cc7fe6 Refactor on GildedRose: make items immutable in GildedRose class
* 7836874 Refactor on GildedRose: make items private in GildedRose class
* 0d48b5d Refactor on GildedRose: use operator-assignments '-='
* 2d1df43 Add approval tests coverage
* a747513 Added initial structure and approval tests
```