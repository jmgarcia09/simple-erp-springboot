Feature: Modulo tags

  Scenario: Ingreso satisfactorio al componente tags
    Given se tiene acceso al sistema (user=test, password=test) usando la url http://54.201.200.23:5665/login
      And acceso al dashboard principal
     When se expande el menu Services
      And se selecciona el apartado Tags
     Then se redirige a la url http://54.201.200.23:5665/tags
      And se visualiza el modulo de tags

  Scenario: Agregar Tag dentro del modulo de Tags
    Given se tiene acceso al sistema (user=test, password=test) usando la url http://54.201.200.23:5665/login
    And acceso al dashboard principal
    And acceso al modulo de tags
    When se selecciona Create Tag
    Then se redirige a la url http://54.201.200.23:5665/tags/new
    And se visualiza el formulario para agregar tag