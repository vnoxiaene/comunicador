package com.jalautopecas.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

import com.jalautopecas.models.SugestaoDeCadastro;
import com.jalautopecas.models.Vendedor;
import com.jalautopecas.repositories.SugestaoDeCadastroRepository;
import com.jalautopecas.repositories.VendedorRepository;

@Controller
@RequestMapping("/produto")
public class SugestaoDeCadastroController {

	private final String PRODUTO_URI = "produto/";
	private final SugestaoDeCadastroRepository sugestaoDeCadastroRepository;
	private final VendedorRepository vendedorRepository;

	public SugestaoDeCadastroController(SugestaoDeCadastroRepository sugestaoDeCadastroRepository,
			VendedorRepository vendedorRepository) {
		this.sugestaoDeCadastroRepository = sugestaoDeCadastroRepository;
		this.vendedorRepository = vendedorRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<SugestaoDeCadastro> produtos = this.sugestaoDeCadastroRepository.findAll();

		return new ModelAndView(PRODUTO_URI + "list", "produtos", produtos);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") SugestaoDeCadastro cadastro) {
		return new ModelAndView(PRODUTO_URI + "view", "produto", cadastro);

	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute("produto") SugestaoDeCadastro cadastro) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("todosVendedores", vendedorRepository.findAll());
		return new ModelAndView(PRODUTO_URI + "form", model);
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid @ModelAttribute("produto") SugestaoDeCadastro produto, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView(PRODUTO_URI + "form", "formErrors", result.getAllErrors());
		} else {
			Vendedor v = vendedorRepository.findOne(produto.getVendedor().getId());
			produto.setDatadeabertura(new Date());
			produto = this.sugestaoDeCadastroRepository.save(produto);
			v.getCadastros().add(produto);
			this.vendedorRepository.save(v);
		}
		redirect.addFlashAttribute("globalMessage", "Cadastro de produto gravada com sucesso");
		return new ModelAndView("redirect:/" + PRODUTO_URI + "{produto.id}", "produto.id", produto.getId());
	}

}
