Feature: add Loan

  Scenario Outline: User1 request to loan Title 0001048082
    Given User login in system as <userName> <password>
    And User clicked on online library system button
    And User enter <ISBN> for searching book
    Then system found Book
    And User clicked check out to borrow book
    And System promote success message in loan page

    Examples: 
      | userName | password   | ISBN       |
      | "admin"  | "COMP5104" | 0001048082 |

  @Tester
  Scenario Outline: User1 Request to return Title 0001048082
    Given User login in system as <userName> <password>
    And User clicked on online library system button
    Then System found loan record
    And User checked renew option for it's book and submit
    Then System promote success message in loan page

    Examples: 
      | userName | password   | ISBN       |
      | "admin"  | "COMP5104" | 0001048082 |
      
  
  Scenario Outline: User1 Request to return Title 0001048082
    Given User login in system as <userName> <password>
    And User clicked on online library system button
    Then System found loan record
    And User checked return option for it's book and submit
    Then System promote success message in loan page

    Examples: 
      | userName | password   | ISBN       |
      | "admin"  | "COMP5104" | 0001048082 |
