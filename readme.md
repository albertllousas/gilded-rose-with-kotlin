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