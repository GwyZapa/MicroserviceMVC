package br.fiap.app.exemplo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fiap.app.exemplo.models.Clientes;

@Controller
@RequestMapping("/cliente")
public class clientesController {
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("cliente/clientes");
		List<Clientes> listaCliente = new ArrayList<Clientes>();

		Clientes dados = new Clientes(); 
		dados.setIdade(20);
		dados.setName("Giovanna");
		
		Clientes dados2 = new Clientes();
		dados2.setIdade(20);
		dados2.setName("Guilherme");
		
		Clientes dados3 = new Clientes();
		dados3.setIdade(60);
		dados3.setName("Hilbert");
		
		Clientes dados4 = new Clientes();
		dados4.setIdade(40);
		dados4.setName("Halpert");
		
		
		listaCliente.add(dados);
		listaCliente.add(dados2);
		listaCliente.add(dados3);
		listaCliente.add(dados4);
		
		model.addObject("clientes", listaCliente);
		return model;
	}
	
	@GetMapping("/editCliente/{id}")
	public String getById(Model model, @PathVariable("id")Integer idCliente) {
		model.addAttribute("idCliente", idCliente);
		return "produto/edit";
	}
	
}
