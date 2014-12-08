Feature: Test for Ti4

  Scenario Outline: User1 borrow copy1 of Title 0001048082
    Given User login in system as <userName> <password>
    When User clicked on online library system button
    And User enter <ISBN> for searching book
    Then system found Book
    And User clicked check out to borrow book
    And System promote success message in loan page

    Examples: 
      | userName | password   | ISBN       |
      | "admin"  | "COMP5104" | 1112211122 |

  Scenario Outline: User1 return copy1 of Title 0001048082
    Given User login in system as <userName> <password>
    When User enter <ISBN> for searching book
    Then System found loan record
    And User checked return option for it's book and submit
    Then System promote success message in loan page

    Examples: 
      | userName | password   | ISBN       |
      | "admin"  | "COMP5104" | 1112211122 |

  Scenario Outline: User2 borrow copy1 of Title 0001048082
    Given User login in system as <userName> <password>
    And User enter <ISBN> for searching book
    Then system found Book
    And User clicked check out to borrow book
    And System promote success message in loan page

    Examples: 
      | userName | password | ISBN       |
      | "yang"   | "123456" | 1112211122 |

  Scenario Outline: User1 borrow copy1 of Title 0001048082
    Given User login in system as <userName> <password>
    And User clicked on online library system button
    And User enter <ISBN> for searching book
    Then system found Book
    And User clicked check out to borrow book
    And System promote fail message in loan page

    Examples: 
      | userName | password   | ISBN       |
      | "admin"  | "COMP5104" | 1112211122 |
