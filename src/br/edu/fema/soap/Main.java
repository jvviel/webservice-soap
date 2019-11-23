package br.edu.fema.soap;

import javax.xml.ws.Endpoint;

import br.edu.fema.soap.service.ProdutoService;

public class Main {

	public static void main(String[] args)
	  {
	    Endpoint.publish("http://127.0.0.1:9876/prod",
	    new ProdutoService());
	  }
}
