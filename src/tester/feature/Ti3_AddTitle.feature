Feature: T3i add title;

  Scenario Outline: create title t1
    Given record Logger "Ti3 Add Title --Create title t1"
    And Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>,<Title>,<Author>,<Publisher>
    And Librarian clicked on create title button
    Then System promote success message in title page

    Examples: 
      | ISBN       | Title        | Author           | Publisher          |
      | 1122111112 | "Test Title" | "Aaron, Raymond" | "1stBooks Library" |

  Scenario Outline: Attempt to create t1 again
    Given record Logger "Ti3 Add Title -- Attempt to create t1 again"
    And Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>,<Title>,<Author>,<Publisher>
    And Librarian clicked on create title button
    Then System promote fail message in title page

    Examples: 
      | ISBN       | Title        | Author           | Publisher          |
      | 1122111112 | "Test Title" | "Aaron, Raymond" | "1stBooks Library" |
