package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {
	

	private Double x;
	private Double y;
	private Double totalCreditCost;
	private Double monthlyInstallment;
	private Double creditYears;

	@Inject
	FacesContext ctx;

	

	public boolean doTheMath() {
		try {
			double x = this.x;
			double y = this.y;

			totalCreditCost = x + x*(y/100);
			monthlyInstallment = totalCreditCost/(creditYears*12);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "BÅ‚Ä…d podczas przetwarzania parametrÃ³w", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}
	
	// Put result in messages on AJAX call
		public String calc_AJAX() {
			if (doTheMath()) {
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ca³kowity koszt kredytu: " + totalCreditCost, null));
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rata miesiêczna: " + monthlyInstallment, null));
			}
			return null;
		}

	
	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getTotalCreditCost() {
		return totalCreditCost;
	}

	public void setTotalCreditCost(Double result) {
		this.totalCreditCost = result;
	}
	
	public Double getCreditYears() {
		return creditYears;
	}

	public void setCreditYears(Double creditYears) {
		this.creditYears = creditYears;
	}

	
	public String info() {
		return "info";
	}

	public Double getMonthlyInstallment() {
		return monthlyInstallment;
	}

	public void setMonthlyInstallment(Double monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}
}
