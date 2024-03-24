Feature: Place An Order For A Pet

  Scenario: verify the POST api for a purchase order with an valid ID
    Given I hit the url of post api to place an order
    When I pass the request body of post api to place an order
      | id       | 0                        |
      | petId    | 77                       |
      | quantity | 0                        |
      | shipDate | 2024-03-24T08:53:10.663Z |
      | status   | placed                   |
      | complete | true                     |
    Then I receive the response code 200

  Scenario: verify the body response of the POST api for a purchase order with an valid ID
    Given I hit the url of post api to place an order
    When I pass the request body of post api to place an order
      | id       | 96                       |
      | petId    | 77                       |
      | quantity | 0                        |
      | shipDate | 2024-03-24T08:53:10.663Z |
      | status   | placed                   |
      | complete | true                     |
    Then I verify that the response body is equal to
      | id       | 96                           |
      | petId    | 77                           |
      | quantity | 0                            |
      | shipDate | 2024-03-24T08:53:10.663+0000 |
      | status   | placed                       |
      | complete | true                         |