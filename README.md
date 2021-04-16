# bootcamp-simulador
Proyecto utilizando maven y base de datos H2

#EndPoints
 http://localhost:8085/simulador
 
 GET: se obtiene los valores iniciales del simulador. Dias de pago, teas, tarjetas, etc
 
 POST: calcula la cuota inicial a pagar. Recibir como parámetros el siguiente json:
 
			{
			"dni": "10067857",
			"tarjeta": "oro",
			"moneda":"S/",
			"monto": "1600",
			"cuota": "36",
			"tea":"22%",
			"diaPago":"20"
			}
			
			
			Ejemplo respuesta:
			 "resultado": {
				"cuota": "59.503113",
				"moneda": "S/",
				"primeraCuota": "20/5/2021",
				"estado": "exitoso"
			}
			
			

Para las pruebas se registraron DNI's y se les asociaron tarjetas, a continuación la relación de los DNI y tarjetas:	

48267857 clasica,oro,black

10067857 oro

75367857 clasica,black

98756661 clasica	

En caso se desee registrar otros DNI's o asociaciones a tarjetas, modificar el archivo import.sql

De ejemplo, la lista muestra que el DNI 48267857 tiene asociadas tarjetas de tipo: clasica, oro y black. Considerar esta asociación para las pruebas.
