Feature: Borrow

  Scenario Outline: create user u1
    Given Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password>
    And Librarian clicked on create User button
    Then System  promote success message for user creatation

    Examples: 
      | familyName | givenName | MiddleInitial | EmailAddress | UserName     | Password     |
      | "titester" | "yang"    | ""            | "yy1@nb.com" | "ti1tester"  | "a111234567" |
      | "titester" | "yang"    | ""            | "yy1@nb.com" | "ti1tester2" | "a111234567" |

  Scenario Outline: create title t1
    Given Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>,<Title>,<Author>,<Publisher>
    And Librarian clicked on create title button
    Then System promote success message in title page

    Examples: 
      | ISBN       | Title          | Author                            | Publisher          |
      | 3101110110 | "tesater Book" | "(ed), Monique Borgerhoff Mulder" | "1stBooks Library" |
      | 3101110112 | "tesater Book" | "(ed), Monique Borgerhoff Mulder" | "1stBooks Library" |

  Scenario Outline: add item to title t1
    Given User login in system as "admin" "COMP5104"
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on search title button
    Then System found title info <ISBN>
    And Librarian clicked on create Item
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 3101110110 |
      | 3101110110 |
      | 3101110110 |
      | 3101110112 |
      | 3101110112 |
      | 3101110112 |

  Scenario Outline: User1 borrow copy1 of Title <ISBN>
    Given User login in system as <userName> <password>
    When User clicked on online library system button
    And User enter <ISBN> for searching book
    Then system found Book <ISBN> <ItemNum>
    And User clicked check out to borrow book
    And System promote success message in loan page

    Examples: 
      | userName     | password   | ISBN        | ItemNum |
      | "ti1tester"  | "COMP5104" | 0006478824  | 1       |
      | "ti1tester"  | "COMP5104" | 3101110112  | 3       |
      | "ti1tester2" | "COMP5104" | 31011101102 | 2       |
      | "ti1tester2" | "COMP5104" | 31011101102 | 2       |
