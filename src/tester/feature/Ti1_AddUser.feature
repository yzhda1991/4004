Feature: Ti1 add user

  Scenario Outline: create user u1
    Given record Logger "Ti1 add user -- create user u1"
    And Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password>
    And Librarian clicked on create User button
    Then System  promote success message in user page

    Examples: 
      | familyName  | givenName     | MiddleInitial | EmailAddress                       | UserName     | Password  |
      | "titesterA" | "LasttesterB" | ""            | "titesterA_LasttesterB@tester.com" | "ti1Tester1" | "a123456" |

  Scenario Outline: attempt to create user u1 again
    Given record Logger "Ti1 add user -- Attempt to create u1 again"
    Given Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password>
    And Librarian clicked on create User button
    Then System promote fail message in user page

    Examples: 
      | familyName  | givenName     | MiddleInitial | EmailAddress                       | UserName     | Password  |
      | "titesterA" | "LasttesterB" | ""            | "titesterA_LasttesterB@tester.com" | "ti1Tester1" | "a123456" |
