package br.fiap.app.exemplo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.fiap.app.exemplo.models.Categoria;
import br.fiap.app.exemplo.models.Produtos;


@Controller
@RequestMapping("/produto")
public class ProdutosController {

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("produto/index");
		List<Produtos> listaProduto = new ArrayList<Produtos>();

		Produtos produtoUm = new Produtos(); 
		produtoUm.setId(new Long(1));
		produtoUm.setNome("Nike Lebrom");
		
		Produtos produtoDois = new Produtos();
		produtoDois.setId(new Long(2));
		produtoDois.setNome("Nike do Naldo");
		
		listaProduto.add(produtoUm);
		listaProduto.add(produtoDois);
		
		model.addObject("produtos", listaProduto);
		return model;
	}
	
	@GetMapping("/edit/{id}")
	public String getById(Model model, @PathVariable("id")Integer idProduto) {
		model.addAttribute("idProduto", idProduto);
		return "produto/edit";
	}
	
	@GetMapping("/create")
	public String create() {
		return "produto/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("produto") Produtos objProduto) {
		//enviar para a base de dados
		System.out.println(objProduto.getNome());
		System.out.println(objProduto.getId());
		return "redirect:/produto";
	}

	@GetMapping("/categoria")
	@ResponseBody 
	public Categoria getCategoria() {
		Categoria categoria = new Categoria();
		categoria.setDescricao("Masculino");
		categoria.setId(1);
		return categoria;
	}
}