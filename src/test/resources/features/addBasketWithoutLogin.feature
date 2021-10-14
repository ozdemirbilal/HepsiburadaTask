@smoke
  Feature: Add product to cart without Login

    @scenario2
    Scenario: User should be able to add 2 product to cart without Login
      Given Navigate to home page
      When The user goes to "Kitap, Müzik, Film, Hobi" "Uzaktan Kumandalı Araçlar"
      And Click on Drone Yedek Parçaları
      And Choose one drone product on search page
      Then Verify that 1 drone product is added to cart