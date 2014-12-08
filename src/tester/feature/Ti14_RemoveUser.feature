Feature: Ti14 remove user

  Scenario Outline: remove user u1
    Given Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <UserName>
    And Librarian clicked on search User button
    Then System find user info <UserName>
    And Librarian click delete button
    And System  promote fail message in user page

    Examples: 
      | UserName       |
      | "testtvasdaas" |
