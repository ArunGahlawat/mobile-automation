Feature: Workindia signup feature
  Description: The purpose is to verify signup functionality is working fine

  @Signup @Negative
  Scenario Outline: Verify Signup with invalid details
    Given App is launched
    When User input "<FullName>" as Full Name
    And User input "<MobileNumber>" as mobile number
    And User clicks on submit button
    Then Verify Input is not accepted as valid input

    Examples:
      | FullName | MobileNumber |
      |          |              |
      | TestUser |              |
      |          | 9800000000   |
      | TestUser | 0000000000   |


  @Signup @Functional @Fresher
  Scenario: Verify Signup of a Fresher in Delhi
    Given App is launched
    When User provides basic details
    And User selects city as "Delhi"
    And User input "Karol Bagh" as Nearest location
    And User submit city selection
    And User selects gender as "Male"
    And User selects qualification as "Graduate"
    And User selects school medium as "English"
    And User selects english speaking level as "Fluent English"
    And User selects "Fresher" as Experience
    And User input age as "20 Years"
    And User selects "Back Office" as Interest area
    And User submit personal details
    Then Verify details are submitted successfully

  @Signup @Functional @Experience
  Scenario: Verify Signup of a Experience in Pune
    Given App is launched
    When User provides basic details
    And User selects city as "Pune"
    And User input "Thane" as Nearest location
    And User submit city selection
    And User selects gender as "Female"
    And User selects qualification as "Graduate"
    And User selects school medium as "English"
    And User selects english speaking level as "Fluent English"
    And User selects "Experience" as Experience
    And User input age as "25 Years"
    And User selects "Back Office" as Interest area
    And User submit personal details
    Then Verify details are submitted successfully
