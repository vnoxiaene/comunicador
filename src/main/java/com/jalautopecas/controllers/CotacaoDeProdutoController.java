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

import com.jalautopecas.models.CotacaoDeProduto;
import com.jalautopecas.models.Vendedor;
import com.jalautopecas.repositories.CotacaoDeProdutoRepository;
import com.jalautopecas.repositories.VendedorRepository;

@Controller
@RequestMapping("/cotacao")
public class CotacaoDeProdutoController {

	private final String COTACAO_URI = "cotacao/";
	private final CotacaoDeProdutoRepository cotacaoDeProdutoRepository;
	private final VendedorRepository vendedorRepository;

	public CotacaoDeProdutoController(CotacaoDeProdutoRepository cotacaoDeProdutoRepository,
			VendedorRepository vendedorRepository) {
		this.cotacaoDeProdutoRepository = cotacaoDeProdutoRepository;
		this.vendedorRepository = vendedorRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<CotacaoDeProduto> cotacoes = this.cotacaoDeProdutoRepository.findAll();
		return new ModelAndView(COTACAO_URI + "list", "cotacoes", cotacoes);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") CotacaoDeProduto cotacao) {
		return new ModelAndView(COTACAO_URI + "view", "cotacao", cotacao);
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute("cotacao") CotacaoDeProduto cotacao) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("todosVendedores", vendedorRepository.findAll());
		return new ModelAndView(COTACAO_URI + "form", model);
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid @ModelAttribute("cotacao") CotacaoDeProduto cotacao, BindingResult result,
			RedirectAttributes redirect) {
		cotacao.setDatadeabertura(new Date());
		if (result.hasErrors()) {
			return new ModelAndView(COTACAO_URI + "form", "formErrors", result.getAllErrors());
		} else {
			Vendedor v = vendedorRepository.findOne(cotacao.getVendedor().getId());
			cotacao = this.cotacaoDeProdutoRepository.save(cotacao);
			v.getCotacoes().add(cotacao);
			this.vendedorRepository.save(v);
		}
		redirect.addFlashAttribute("globalMessage", "Cotação de produto gravada com sucesso");
		return new ModelAndView("redirect:/" + COTACAO_URI + "{cotacao.id}", "cotacao.id", cotacao.getId());
	}

}
