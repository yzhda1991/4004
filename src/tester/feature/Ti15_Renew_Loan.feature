Feature: Ti15, Renew loan copy

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
      | ISBN       | Title           | Author           | Publisher          |
      | 3101112111 | "teasater Book" | "Aaron, Raymond" | "1stBooks Library" |

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
    Then system found Book
    And User clicked check out to borrow book
    And System promote success message in loan page

    Examples: 
      | userName | password   | ISBN       |
      | "admin"  | "COMP5104" | 1112211122 |
      | "admin"  | "COMP5104" | 0001048082 |

  Scenario Outline: User1 return copy1 of Title 0001048082
    Given User login in system as <userName> <password>
    When User enter <ISBN> for searching book
    Then System found loan record
    And User checked return option for it's book and submit
    Then System promote success message in loan page

    Examples: 
      | userName | password   | ISBN       |
      | "admin"  | "COMP5104" | 0001048082 |

  Scenario Outline: User1 renew copy1 of Title <ISBN>
    Given User login in system as <userName> <password>
    When User clicked on online library system button
    And User enter <ISBN> for searching book
    Then system found Book <ISBN> <ItemNum> on its loan for renew
    And User clicked submit
    And System promote success message in loan page

    Examples: 
      | userName | password   | ISBN       | ItemNum |
      | "admin"  | "COMP5104" | 0006478824 | 1       |
