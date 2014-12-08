Feature: scenario Definition

  Scenario Outline: create user success
    Given System log in as Librarian "admin" "COMP5104"
    When Librarian is on maintain user page
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password> on maintain user page
    And Librarian clicked on create User button on maintain user page
    Then System promote success message in user page contains <UserName>

    Examples: 
      | familyName  | givenName     | MiddleInitial | EmailAddress                        | UserName   | Password  |
      | "titesterA" | "LasttesterB" | ""            | "titestaerA_LasttesterB@tester.com" | "tempUser" | "a123456" |

  Scenario Outline: create user fail
    Given System log in as Librarian "admin" "COMP5104"
    When Librarian is on maintain user page
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password> on maintain user page
    And Librarian clicked on create User button on maintain user page
    Then System promote fail message in user page contains <UserName>

    Examples: 
      | familyName  | givenName     | MiddleInitial | EmailAddress                        | UserName   | Password  |
      | "titesterA" | "LasttesterB" | ""            | "titestaerA_LasttesterB@tester.com" | "tempUser" | "a123456" |

  Scenario Outline: remove user success
    Given System log in as Librarian "admin" "COMP5104"
    When Librarian is on maintain user page
    And Librarian input <UserName> at userName field in maintain user page
    And Librarian clicked on search User button on maintain user page
    Then System find available user info <UserName>
    And Librarian clicked on delete user button on maintain user pages
    And System promote success message in user page contains <UserName>

    Examples: 
      | familyName  | givenName     | MiddleInitial | EmailAddress                        | UserName   | Password  |
      | "titesterA" | "LasttesterB" | ""            | "titestaerA_LasttesterB@tester.com" | "tempUser" | "a123456" |

  Scenario Outline: remove user fail
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
