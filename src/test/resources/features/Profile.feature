Feature: Workindia profile update feature
  Description: The purpose is to verify profile functionality is working fine


  @Profile @Profile_Personal_Details_Edit @Functional
  Scenario: Verify user is able to change English fluency
    Given App is launched
    And User is registered
    And Job feeds section is open
    When User goes to "Profile" section
    And Selects my profile option
    And Selects English fluency to "Good English"
    And Clicks on Update profile button
    Then Verify profile is updated successfully

  @Profile @Profile_Basic_Details_Edit @Functional
  Scenario: Verify user is able to update mobile number and Full Name
    Given App is launched
    And User is registered
    And Job feeds section is open
    When User goes to "Profile" section
    And Selects my profile option
    And Clicks on edit profile link
    And updates Full name to "Shivani ABCD"
    And updates Mobile number to "9000000000"
    And Clicks on DONE
    Then Verify full name is updated as "Shivani ABCD" and mobile number is updated as "9000000000"
