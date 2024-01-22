Feature: Quiero validar el login
Scenario: Validar que el login sea el correcto
	Given Abrir Chrome
	 When Ingresa correctamente Username "1" y Password "1"
	 Then Validar que el title sea Welcome