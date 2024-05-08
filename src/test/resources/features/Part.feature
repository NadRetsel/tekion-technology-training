Feature: CRUD operations for Part

    Background: Creating an existing populated Part Repository
    Given a list of PartDTOs
      | description | price |
      | item 1      | 100   |
      | item 2      | 200   |
      | item 3      | 300   |
    When save to Part Repository
    Then Part Repository is populated


#  Scenario Outline: Creating Part Entity from Part DTO
#    Given Part DTO description <description>
#      And Part DTO price <price>
#    When attempt to create new Part Entity
#    Then Part Entity should be filled
#      And Part Repository should have <expectedCount> items
#
#    Examples:
#      | description | price | expectedCount |
#      | "item1" | "100" | 1 |


#  Scenario Outline: Failing Part Entity from invalid Part DTO
#    Given Part DTO description <description>
#      And Part DTO price <price>
#    When attempt to create new Part Entity
#    Then Part Entity should not be created
#      And Part Repository should have <expectedCount> items
#
#    Examples:
#      | description | price | expectedCount |
#      | "item1" | "bad price" | 0 |


  Scenario Outline: Reading Part Entity
    Given Part Entity to search has description <description>
    When find Part Entity with matching description in Part Repository
    Then expect non-null Part Entity

    Examples:
    | description |
    | "item 1"    |
    | "item 2"    |
    | "item 3"    |
