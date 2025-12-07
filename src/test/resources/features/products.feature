Feature: API de Productos de FakeStore

  Como tester de API
  Quiero validar los endpoints de productos
  Para asegurar que funcionen correctamente

  Scenario: Obtener todos los productos
    Given  el servicio de productos esta diponible
    When envio una peticion GET a productos
    Then el codigo de respues debe ser 403


  Scenario: Obtener un producto por ID
    Given  el servicio de productos esta diponible
    When envio una perticion GET al producto con ID 1
    Then el codigo de respues debe ser 403
