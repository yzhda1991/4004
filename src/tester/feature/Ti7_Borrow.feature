Feature: Test for Ti7

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
      | "admin"  | "COMP5104" | 0006478824 |
