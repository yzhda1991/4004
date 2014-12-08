Feature: Tv2 Create User

  Scenario Outline: create user u1
    Given Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password>
    And Librarian clicked on create User button
    Then System  promote success message in user page

    Examples: 
      | familyName | givenName | MiddleInitial | EmailAddress | UserName  | Password     |
      | "comp"     | "scsc"    | ""            | "yy1@nb.com" | "testtv2" | "a111234567" |

  Scenario Outline: remove user u1
    Given Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <UserName>
    And Librarian clicked on search User button
    Then System find user info <UserName>
    And Librarian click delete button
    And System  promote success message in user page

    Examples: 
      | UserName  |
      | "testtv2" |

  Scenario Outline: create user u1
    Given Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password>
    And Librarian clicked on create User button
    Then System  promote success message for user creatation

    Examples: 
      | familyName | givenName | MiddleInitial | EmailAddress | UserName  | Password     |
      | "comp"     | "scsc"    | ""            | "yy1@nb.com" | "testtv2" | "a111234567" |
