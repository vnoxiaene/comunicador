package com.jalautopecas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jalautopecas.models.Vendedor;
import com.jalautopecas.repositories.VendedorRepository;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {

	private final VendedorRepository repository;
	private final String VENDEDOR_URI = "vendedores/";
	
	public VendedorController(VendedorRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Vendedor> vendedores = this.repository.findAll();
		return new ModelAndView(VENDEDOR_URI + "list","vendedores",vendedores);
	}
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Vendedor vendedor) {
		return new ModelAndView(VENDEDOR_URI+"view","vendedor",vendedor);
	}
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Vendedor vendedor) {
		return VENDEDOR_URI+"form";
	}
	@PostMapping(params = "form")
	public ModelAndView create(@Valid Vendedor vendedor,BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(VENDEDOR_URI+"form","formErrors",result.getAllErrors());}
		vendedor = this.repository.save(vendedor);
		redirect.addFlashAttribute("globalMessage","Vendedor gravado com sucesso");
		return new ModelAndView("redirect:/"+VENDEDOR_URI+"{vendedor.id}","vendedor.id",vendedor.getId());
	}
	@GetMapping(value = "remover/id")
	public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		this.repository.delete(id);
		Iterable<Vendedor> vendedores = this.repository.findAll();
		ModelAndView mv = new ModelAndView(VENDEDOR_URI+"list","vendedores",vendedores);
		mv.addObject("globalMessage","Cliente removido com sucesso");
		return mv;
	}
	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Vendedor vendedor) {
		return new ModelAndView(VENDEDOR_URI+"form","vendedor",vendedor);
	}
	
	
	
}
