Feature: CRUD operations for Product

  Scenario Outline: Creating Product Entity from valid Product DTO
    Given product dto description <description>
      And product dto price <price>
    When attempt to create new product entity
    Then product entity should be filled
      And repository should have <expectedCount> item

    Examples:
      | description | price | expectedCount |
      | "item1" | 100 | 1 |
      | "item2 | "bad price" | 0 |


  Scenario Outline: Failing Product Entity from invalid Product DTO
    Given product dto description <description>
      And product dto price <price>
    When attempt to create new product entity
    Then product entity should not be created
      And repository should have <expectedCount> item

    Examples:
      | description | price | expectedCount |
      | "item1" | 100 | 1 |
      | "item2 | "bad price" | 0 |