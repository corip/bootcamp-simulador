package com.simulador.compras.models.dto;



import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Request {
	
	
	@NotNull(message = "DNI no es válido")
	@Digits(fraction = 0, integer = 8)
	 @Size(min = 8, max = 8, message = "DNI no es válido")
	private String dni;
	
	@NotNull(message = "Tarjeta no válida")
	private String tarjeta;
	
	@NotNull(message = "Moneda no válida")
	private String moneda;
	
	@NotNull(message = "Monto no válido")
	private String monto;
	
	@NotNull(message = "Cuota no válida")
	@Range(min=1, max=36, message="Cuota debe estar entre 1 y 36")
	private String cuota;
	
	@NotNull(message = "tea no válida")
	private String tea;
	
	@NotNull(message = "Día de pago no válido")
	private String diaPago;
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getCuota() {
		return cuota;
	}
	public void setCuota(String cuota) {
		this.cuota = cuota;
	}
	public String getTea() {
		return tea;
	}
	public void setTea(String tea) {
		this.tea = tea;
	}
	public String getDiaPago() {
		return diaPago;
	}
	public void setDiaPago(String diaPago) {
		this.diaPago = diaPago;
	}

	
	
}
