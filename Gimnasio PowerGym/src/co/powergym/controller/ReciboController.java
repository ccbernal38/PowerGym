package co.powergym.controller;

import co.powergym.dao.ReciboDao;
import co.powergym.view.ReciboView;

public class ReciboController {

	private ReciboView reciboView;

	private ReciboDao reciboDao;

	public ReciboController(ReciboView reciboView) {
		this.reciboView = reciboView;
		reciboDao = new ReciboDao();
		if (this.reciboView != null) {
			reciboView = new ReciboView();
			
		}
	}

}
