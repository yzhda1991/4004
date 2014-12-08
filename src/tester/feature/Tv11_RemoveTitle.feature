Feature: Tv11 Remove Title

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

  Scenario Outline: add item to title t1
    Given Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on search title button
    Then System found title info <ISBN>
    And Librarian clicked on create Item
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 3101112111 |

  Scenario Outline: User1 borrow copy1 of Title <ISBN>
    Given User login in system as <userName> <password>
    When User clicked on online library system button
    And User enter <ISBN> for searching book
    Then system found Book <ISBN> <ItemNum>
    And User clicked check out to borrow book
    And System promote success message in loan page

    Examples: 
      | userName  | password   | ISBN       | ItemNum |
      | "testtv2" | "COMP5104" | 0006478824 | 1       |
      
      Scenario Outline: User1 borrow copy1 of Title <ISBN>
    Given User login in system as <userName> <password>
    When User clicked on online library system button
    And User enter <ISBN> for searching book
    Then system found Book <ISBN> <ItemNum>
    And User checked return option for it's book and submit
    And System promote success message in loan page

    Examples: 
      | userName     | password   | ISBN        | ItemNum |
      | "ti1tester"  | "COMP5104" | 0006478824  | 1       |
      | "ti1tester"  | "COMP5104" | 3101110112  | 3       |
      | "ti1tester2" | "COMP5104" | 31011101102 | 2       |
      | "ti1tester2" | "COMP5104" | 31011101102 | 2       |
      
      Scenario Outline: remove title t1
    Given Librarian is on libarian form page
    When Librarian clicked on maintain Title
    And Librarian input <ISBN>
    And Librarian clicked on search title button
    Then System found title info <ISBN>
    And Librarian clicked on delete Title
    Then System promote success message in title page

    Examples: 
      | ISBN       |
      | 3102121101 |
