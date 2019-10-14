Feature: Workindia signup feature
	Description: The purpose is to verify signup functionality is working fine

	Scenario Outline: Verify Signup with invalid details
		Given App is launched
		When User input "<FullName>" as Full Name
		And User input "<MobileNumber>" as mobile number
		And User clicks on submit button
		Then Verify Input is not accepted as valid input

		Examples:
		|FullName		|MobileNumber	|
		|		        |				|
		|TestUser	 	|	   			|
		|				|9800000000		|
		|TestUser		|0000000000		|
