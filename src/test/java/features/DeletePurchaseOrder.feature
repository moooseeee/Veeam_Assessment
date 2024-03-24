Feature: Delete Purchase Order By ID

  Scenario: verify the delete api for a purchase order with an valid ID
    Given I hit the url of delete api for purchased order
    When I pass the request body of post api to place an order
      | id       | 4                        |
      | petId    | 77                       |
      | quantity | 0                        |
      | shipDate | 2024-03-24T08:53:10.663Z |
      | status   | placed                   |
      | complete | true                     |
    Then I receive the response code 200
    When I pass the url of delete api for purchased order with the ID "4"
    Then I receive the response code 200

  Scenario: verify the delete api for a purchase order with an invalid ID
    Given I hit the url of delete api for purchased order
    When I pass the url of delete api for purchased order with the ID "4"
    Then I receive the response code 404

  Scenario: verify the body response of the delete api for a purchase order with an invalid ID
    Given I hit the url of delete api for purchased order
    When I pass the url of delete api for purchased order with the ID "4"
    Then I receive the response code 404
    Then I verify that the response body is equal to
      | code    | 404             |
      | type    | unknown         |
      | message | Order Not Found |

  Scenario: verify the body response of the delete api for a purchase order with an invalid ID
    Given I hit the url of delete api for purchased order
    When I pass the url of delete api for purchased order with the ID "96"
    Then I receive the response code 200
    Then I verify that the response body is equal to
      | code    | 200     |
      | type    | unknown |
      | message | 96      |