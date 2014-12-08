Feature: temp

 

  Scenario Outline: remove user failS
    Given System log in as Librarian "admin" "COMP5104"
    When Librarian is on maintain user page
    And Librarian input <UserName> at userName field in maintain user page
    And Librarian clicked on search User button on maintain user page
    Then System find available user info <UserName>
    ##And Librarian clicked on delete user button on maintain user pages
    And System promote fail message in user page contains "No"

    Examples: 
      | familyName  | givenName     | MiddleInitial | EmailAddress                        | UserName   | Password  |
      | "titesterA" | "LasttesterB" | ""            | "titestaerA_LasttesterB@tester.com" | "tempUser" | "a123456" |
