Feature: Check and Verify the user Interface should be proper
  Background: Interface
  Given:the calculator application is open

  @smoke @name
  Scenario: Verify user is able to display the name of the calculator
    When the user looks at the application name should be "Tech Elliptica Basic Calculator" display

  @smoke @logo
  Scenario: Verify whether the logo is displayed on the calculator
    When the user looks at the logo
    Then the user should see the "Tech Elliptica" logo


     @smoke @size
  Scenario: Verify that the input/output screen size of the calculator remains constant
        When the user inputs "111111111111111111"
        Then the screen size should remain constant

       @smoke @constant
  Scenario: Verify that the input/output screen size remains constant even when error messages are displayed
        When the user enters invalid input
        Then the screen size should remain constant
        And no error message should be displayed


  @smoke @buttons
  Scenario: Verify that numbers are properly displayed buttons and user is able to click or not
    When the user looks at the number buttons
    Then the user should see buttons for 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9
    And the user should be able to click these buttons



