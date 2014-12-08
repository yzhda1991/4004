Feature: Ti4 Borrow

  Scenario Outline: Create User1 and User2
    Given record Logger "Ti4 Borrow --Create users u1, u2"
    And Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password>
    And Librarian clicked on create User button
    Then System  promote success message in user page

    Examples: 
      | familyName  | givenName   | MiddleInitial | EmailAddress                     | UserName     | Password  |
      | "titesterB" | "titesterB" | ""            | "titesterB_titesterB@tester.com" | "ti4Tester1" | "a123456" |
      | "titesterC" | "titesterC" | ""            | "titesterC_titesterC@tester.com" | "ti4Tester2" | "a123456" |

  Scenario Outline: create title t1
    Given record Logger "Ti4 Borrow --Create title t1"
    And Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>,<Title>,<Author>,<Publisher>
    And Librarian clicked on create title button
    Then System promote success message in title page

    Examples: 
      | ISBN       | Title          | Author           | Publisher          |
      | 1122111124 | "Test Title 3" | "Stanley, Mandy" | "1stBooks Library" |

  Scenario Outline: Create copy1 of t1
    Given record Logger "Ti4 Borrow --Create copy1 of t1"
    And Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on Search button
    Then System found title info <ISBN>
    And Librarian clicked on create Item
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 1122111124 |

  Scenario Outline: User1 borrow copy1 of t1
    Given record Logger "Ti4 Borrow --Have user u1 borrow copy1 of t1"
    And User login in system as <userName> <password>
    And User enter <ISBN> for searching book
    Then System found available item record with <ISBN>,<ItemNum> for borrow
    And User clicked check out to borrow book
    And System promote success message in loan page

    Examples: 
      | userName     | password  | ISBN       | ItemNum |
      | "ti4Tester1" | "a123456" | 1122111124 | 1       |

  Scenario Outline: User2 borrow copy1 of t1
    Given record Logger "Ti4 Borrow --Have user u2 request copy1 of t1"
    And User login in system as <userName> <password>
    And User enter <ISBN> for searching book
    Then System found available item record with <ISBN>,<ItemNum> for borrow
    And User clicked check out to borrow book
    And System promote fail message in loan page

    Examples: 
      | userName     | password  | ISBN       | ItemNum |
      | "ti4Tester2" | "a123456" | 1122111124 | 1       |
