Feature: add Item

  Scenario Outline: create title t1
    Given User login in system as "admin" "COMP5104"
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>,<Title>,<Author>,<Publisher>
    And Librarian clicked on create title button
    Then System promote success message in title page

    Examples: 
      | ISBN       | Title           | Author           | Publisher          |
      | 3101112111 | "teasater Book" | "Aaron, Raymond" | "1stBooks Library" |

  Scenario Outline: add item to title t1
    Given User login in system as "admin" "COMP5104"
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on search title button
    Then System found title info <ISBN>
    And Librarian clicked on create Item
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 3101112111 |

  Scenario Outline: add item to title t1
    Given User login in system as "admin" "COMP5104"
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on search title button
    Then System found title info <ISBN>
    And Librarian clicked on create Item
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 3101112111 |

  Scenario Outline: add item to title t1
    Given User login in system as "admin" "COMP5104"
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on search title button
    Then System found title info <ISBN>
    And Librarian clicked on create Item
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 3101112111 |

  Scenario Outline: remove Item when Item number not Exists
    Given User login in system as "admin" "COMP5104"
    When Librarian clicked on maintain Item
    And Librarian input <ISBN> on maintain item page
    And Librarian clicked on Search button on maintain item page
    Then System found item record with <ISBN>,<itemNum>
    And Librarian clik submit button
    And System promote success message for item deletation

    Examples: 
      | ISBN       | itemNum |
      | 0001048082 | 2       |

  Scenario Outline: add item to title t1
    Given User login in system as "admin" "COMP5104"
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on search title button
    Then System found title info <ISBN>
    And Librarian clicked on create Item
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 3101112111 |

  Scenario Outline: add item to title t1
    Given User login in system as "admin" "COMP5104"
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on search title button
    Then System found title info <ISBN>
    And Librarian clicked on create Item
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 3101112111 |
