Feature: Modulo Services

  Scenario: SP_1501: Ingreso satisfactorio al componente Services
    Given se tiene acceso al sistema (user=test, password=test) usando la url http://54.201.200.23:5665/login
      And acceso al dashboard principal
    When se expande el menu Services
      And se selecciona el apartado Services
    Then se redirige a la url http://54.201.200.23:5665/services
      And se visualiza el modulo de services

  Scenario: SP_1502: Agregar Service dentro del modulo de Services
    Given se tiene acceso al sistema (user=test, password=test) usando la url http://54.201.200.23:5665/login
    And acceso al dashboard principal
    When se expande el menu Services
    And se selecciona el apartado Services
    When se selecciona Create Service
    Then se redirige a la url http://54.201.200.23:5665/services/new
    And se visualiza el formulario para agregar service

  Scenario: SP_1503: Activar opcion For Sale en modulo Services
    Given se tiene acceso al sistema (user=test, password=test) usando la url http://54.201.200.23:5665/login
    And acceso al dashboard principal
    When se expande el menu Services
    And se selecciona el apartado Services
    When se selecciona la opcion 'For Sale'
    Then se redirige a la url http://54.201.200.23:5665/services?sale_status=FOR_SALE
    And se visualizan unicamente los services con estado 'For Sale'