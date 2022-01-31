Feature: Template Integration Test
  I want to check if the Book Controller is working properly

  Scenario: Checking BookController
    Given I have the book with "Title", "Summary", "Author", "ISBN"
    When I post the book
    Then I should get book with "Title", "Summary", "Author", "ISBN"