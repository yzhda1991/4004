Feature: create user 

Scenario Outline: create user u1
    Given Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password>
    And Librarian clicked on create User button
    Then System  promote success message for user creatation

    Examples: 
      | familyName | givenName | MiddleInitial | EmailAddress | UserName    | Password     |
      | "titester" | "yang"    | ""            | "yy1@nb.com" | "ti1tester" | "a111234567" |