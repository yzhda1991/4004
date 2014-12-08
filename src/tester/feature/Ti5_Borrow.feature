Feature: Test for Ti5

  Scenario Outline: Create User1 and User2
    Given record Logger "Ti5 Borrow --Create users u1, u2"
    And Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password>
    And Librarian clicked on create User button
    Then System  promote success message in user page

    Examples: 
      | familyName  | givenName   | MiddleInitial | EmailAddress                     | UserName     | Password  |
      | "titesterD" | "titesterF" | ""            | "titesterD_titesterF@tester.com" | "ti5Tester1" | "a123456" |
      | "titesterE" | "titesterG" | ""            | "titesterE_titesterG@tester.com" | "ti5Tester2" | "a123456" |

  Scenario Outline: create title t1
    Given record Logger "Ti5 Borrow --Create title t1"
    And Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>,<Title>,<Author>,<Publisher>
    And Librarian clicked on create title button
    Then System promote success message in title page

    Examples: 
      | ISBN       | Title          | Author           | Publisher          |
      | 1122111125 | "Test Title 4" | "Stanley, Mandy" | "1stBooks Library" |

  Scenario Outline: Create copy1 of t1
    Given record Logger "Ti5 Borrow --Create copy1 of t1"
    And Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on Search button
    Then System found title info <ISBN>
    And Librarian clicked on create Item
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 1122111125 |

  Scenario Outline: User1 borrow copy1 of t1
    Given record Logger "Ti4 Borrow --Have user u1 borrow copy1 of t1"
    And User login in system as <userName> <password>
    And User enter <ISBN> for searching book
    Then System found available item record with <ISBN>,<ItemNum> for borrow
    And User clicked check out to borrow book
    And System promote success message in loan page

    Examples: 
      | userName     | password  | ISBN       | ItemNum |
      | "ti5Tester1" | "a123456" | 1122111125 | 1       |

  Scenario Outline: User1 renew copy1 of t1
    Given record Logger "Ti5 Borrow --Have user u1 renew copy1 of t1 within deadline"
    And User login in system as <userName> <password>
    And User enter <ISBN> for searching book
    Then system found Book <ISBN> <ItemNum> on its loan for renew
    And User clicked submit
    And System promote success message in loan page

    Examples: 
      | userName     | password  | ISBN       | ItemNum |
      | "ti5Tester1" | "a123456" | 1122111125 | 1       |

  Scenario Outline: User2 borrow copy1 of t1
    Given record Logger "Ti5 Borrow --Have user u2 request copy1 of t1"
    Given User login in system as <userName> <password>
    And User enter <ISBN> for searching book
    Then System found available item record with <ISBN>,<ItemNum> for borrow
    And User clicked check out to borrow book
    And System promote fail message in loan page

    Examples: 
      | userName     | password  | ISBN       | ItemNum |
      | "ti5Tester2" | "a123456" | 1122111125 | 1       |
