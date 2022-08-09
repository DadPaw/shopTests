Feature: Login funcionality

  Scenario Outline: Login to the Swaglabs page

    Given user is on home page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then user is login and navigated to home page

    Examples:
    | username | password |
    | standard_user    | secret_sauce |
    | performance_glitch_user | secret_sauce|
