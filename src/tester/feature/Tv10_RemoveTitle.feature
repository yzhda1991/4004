Feature: remove Title

  Scenario Outline: create title t1
    Given Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>,<Title>,<Author>,<Publisher>
    And Librarian clicked on create title button
    Then System promote success message in title page

    Examples: 
      | ISBN       | Title          | Author           | Publisher          |
      | 3102121101 | "tesater Book" | "Aaron, Raymond" | "1stBooks Library" |

  Scenario Outline: remove title t1
    Given Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on search title button
    Then System found title info <ISBN>
    And Librarian clicked on delete Title
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 3102121101 |
