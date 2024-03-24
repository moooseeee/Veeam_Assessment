Feature: Get Purchase Order By ID

  Scenario: verify the get api for a purchase order with an valid ID
    Given I hit the url of post api to place an order
    When I pass the request body of post api to place an order
      | id       | 96                       |
      | petId    | 77                       |
      | quantity | 0                        |
      | shipDate | 2024-03-24T08:53:10.663Z |
      | status   | placed                   |
      | complete | true                     |
    Given I hit the url of get api for purchase order
    When I pass the url of get api for purchase order with the ID "96"
    Then I receive the response code 200

  Scenario: verify the get api for a purchase order with an invalid ID
    Given I hit the url of get api for purchase order
    When I pass the url of get api for purchase order with the ID "8"
    Then I receive the response code 404


  Scenario: verify the response body of the get api for a purchase order with a valid ID
    Given I hit the url of get api for purchase order
    When I pass the url of get api for purchase order with the ID "96"
    Then I verify that the response body is equal to
      | id       | 96     |
      | status   | placed |
      | complete | true   |

  Scenario: verify the response body of the get api for a purchase order with an invalid ID
    Given I hit the url of get api for purchase order
    When I pass the url of get api for purchase order with the ID "8"
    Then I verify that the response body is equal to
      | code    | 1               |
      | type    | error           |
      | message | Order not found |