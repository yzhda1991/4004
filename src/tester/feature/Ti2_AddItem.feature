Feature: Ti2 Add Item

  Scenario Outline: Attemp to create a copy to a non-existent title
    Given record Logger "Ti2 add Item -- Attempt to create a copy to a non-existent title"
    And Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on Search button
    Then System promote fail message in title page

    Examples: 
      | ISBN      |
      | 112211111 |
