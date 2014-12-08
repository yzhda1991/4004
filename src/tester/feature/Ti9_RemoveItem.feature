Feature: Remoove Item

  Scenario Outline: remove Item when Item number not Exists
   Given User login in system as "admin" "COMP5104"
   When Librarian clicked on maintain Item
   And Librarian input <ISBN> on maintain item page
   And Librarian clicked on Search button on maintain item page
   Then System found item record with <ISBN>,<itemNum>
   And Librarian clik submit button
   And System promote success message for item deletation

    Examples: 
      | ISBN       | itemNum |
      | 0001048082 | 2       |
