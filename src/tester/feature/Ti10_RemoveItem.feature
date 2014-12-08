Feature: Remove Item

  Scenario Outline: 
    
    Scenario Outline: create user u1

    Given Librarian is on libarian form page
    When Librarian clicked on Maintatin User button
    And Librarian input <familyName> , <givenName>, <MiddleInitial>,<EmailAddress>,<UserName>,<Password>
    And Librarian clicked on create User button
    Then System  promote success message in user page

    Examples: 
      | familyName | givenName | MiddleInitial | EmailAddress | UserName  | Password     |
      | "comp"     | "scsc"    | ""            | "yy1@nb.com" | "testtv2" | "a111234567" |

  Scenario Outline: create title t1
    Given Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>,<Title>,<Author>,<Publisher>
    And Librarian clicked on create title button
    Then System promote success message in title page

    Examples: 
      | ISBN       | Title          | Author                            | Publisher          |
      | 3101110110 | "tesater Book" | "(ed), Monique Borgerhoff Mulder" | "1stBooks Library" |

  Scenario Outline: User1 borrow copy1 of Title <ISBN>
    Given User login in system as <userName> <password>
    When User clicked on online library system button
    And User enter <ISBN> for searching book
    Then system found Book <ISBN> <ItemNum>
    And User clicked check out to borrow book
    And System promote success message in loan page

    Examples: 
      | userName    | password   | ISBN       | ItemNum |
      | "ti1tester" | "COMP5104" | 0006478824 | 1       |

  Scenario Outline: remove Item
    Given User login in system as "admin" "COMP5104"
    When Librarian clicked on maintain Item
    And Librarian input <ISBN> on maintain item page
    And Librarian clicked on Search button on maintain item page
    Then System found item record with <ISBN>,<itemNum>
    And Librarian clik submit button
    And System promote success message for item deletation

    Examples: 
      | ISBN       | itemNum |
      | 0006478824 | 1       |
