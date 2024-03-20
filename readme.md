# Gilded rose kata in kotlin

Original source: https://github.com/emilybache/GildedRose-Refactoring-Kata

## Requirements Specification

[requirements](requirements.md)

## Steps-followed

1. Understand requirements
2. Write [characterization tests](https://en.wikipedia.org/wiki/Characterization_test), a safety net of tests for our legacy code. In our case, we have used https://approvaltests.com/, check [here](refactored/src/test/kotlin/com/gildedrose/ApprovalTest.kt)
3. Make sure our approval tests are passing
4. Perform refactor on the legacy code ( [GildedRose](refactored/src/main/kotlin/com/gildedrose/GildedRose.kt) class) or any new code created during the process ([ItemAger](refactored/src/main/kotlin/com/gildedrose/ItemAger.kt)), go to 3 till we are done
5. **Use TDD** to extract legacy code to a new piece of code, how:
   - Identify code for extraction on the legacy code
   - Apply TDD cycle on the new code: 
      - Write a failing test
      - Write the minimum code to pass the test 
      - Refactor
   - Integrate the new code in the legacy code
6. Come back to 3 till we are done
7. **Use TDD** to add new features (in our case Conjured items)

### Detailed steps

```shell
$> git log --pretty=format:'%s' --abbrev-commit --reverse
Add approval tests coverage
Refactor on GildedRose: use operator-assignments '-='
Refactor on GildedRose: make items private in GildedRose class
Refactor on GildedRose: make items immutable in GildedRose class
Refactor on GildedRose: extract item names as constants in the class
Refactor on GildedRose: change for loop by forEach idiomatic kotlin
Introduce ItemAger class and first scenario: lower quality of a standard item at the end of the day
Add scenario to ItemAger: never lower quality of an item below 0 at the end of the day
Add scenario to ItemAger: never lower the quality of a legendary item
Refactor on GildedRose: Integrate ItemAger for quality decreasement
Add scenario to ItemAger: increase the quality of Aged Brie at the end of the day
Add scenario to ItemAger: never increase the quality of an item above 50
Add scenario to ItemAger: increase the quality of Backstage passes at the end of the day
Refactor on GildedRose: Integrate ItemAger for quality increasement
Add scenario to ItemAger: increase by 3 the quality of Backstage passes 5 days or less before the concert
Add scenario to ItemAger: lower the sellIn of an item at the end of the day
Add scenario to ItemAger: drop the quality to 0 of Backstage passes after the concert
Refactor on GildedRose: Integrate ItemAger new code for backstage quality adter the concert
Add scenario to ItemAger: degrade quality twice as fast once the sell by date has passed
Refactor on GildedRose: Integrate ItemAger new code for degrading quality twice
Add scenario to ItemAger: increase quality twice for aged Brie once the sell by date has passed
Refactor on GildedRose: Remove remaining legacy code
Small refactor on ItemAger: use Item instead of its properties
Small refactor on ItemAger: extract min max quality magic numbers to constants
Refactor on ItemAger: extract age logic in different aging methods
Small refactor on ItemAger: provide min max in construction time
Small refactor on ItemAger: Add ageLegendaryItem method for consistency
Add scenario to ItemAger: lower the quality of a conjured item twice as standard ones
Add scenario to ItemAger: lower quality twice for Conjured items once the sell by date has passed
Refactor on ItemAger: introduce 'ageItem' generic function
Small refactor on ItemAger: Format lines and introduce variable for more legibility
Small refactor on ItemAger: Remove specific functions and use 'age' generic one instead
```