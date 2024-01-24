Feature: Post new picture

  Scenario: User can upload to website picture with comment
    Given user has a picture on local disk
    And user is logged on example-photo-portal.com
    When user click on upload photo
    Then new browser windows opens
    And user click on upload photo button
    And user can select picture from local disk
    And write text in text field
    And user click update status
    And picture is posted on example-photo-portal
