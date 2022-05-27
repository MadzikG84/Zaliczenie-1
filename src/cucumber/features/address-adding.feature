Feature: Adding address

  Scenario Outline: Successful address adding
    Given Opened webpage: https://mystore-testlab.coderslab.pl
    And Click on "Sign in"
    When Enter "oxkbzjqrhslndwzgnt@nvhrw.com" in email field and "12345mm" in password field
    And Press "Sign in" button
    And Press "Addresses" button at the bottom of the page
    And Click on "+Create new address"
    And Fill in valid address data: <alias>, <address>, <city>, <zip>, <country>, <phone>
    Then Save new address
#    And Browser quit


    Examples:
      | alias | address | city   | zip    | country        | phone    |
      | House   | Shogun 2 | London | M11-84 | United Kingdom | 123456789 |