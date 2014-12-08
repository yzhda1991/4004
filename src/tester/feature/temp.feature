Feature: temp

  Scenario Outline: create title fail
    Given System log in as Librarian "admin" "COMP5104"
    When Librarian is on maintain title page
    And Librarian input <ISBN>,<Title>,<Author>,<Publisher> on maintain title page
    And Librarian clicked on create title button on maintain title page
    Then System promote fail message in title page contains <ISBN>

    Examples: 
      | ISBN       | Title        | Author         | Publisher |
      | 1122111112 | "Test Title" | "Fry, Stephen" | "Collins" |
