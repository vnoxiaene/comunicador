package com.jalautopecas.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jalautopecas.models.PrecoConcorrencia;
import com.jalautopecas.repositories.PrecoConcorrenciaRepository;

@Controller
@RequestMapping("/concorrencia")
public class PrecoConcorrenciaController {

	private final String URI = "concorrencia";
	private final PrecoConcorrenciaRepository precoconcorrencia;

	public PrecoConcorrenciaController(PrecoConcorrenciaRepository precoconcorrencia) {
		this.precoconcorrencia = precoconcorrencia;
	}

	@RequestMapping("/")
	public ModelAndView list() {
		Iterable<PrecoConcorrencia> precos = this.precoconcorrencia.findAll();
		return new ModelAndView(URI + "list", "precos", precos);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") PrecoConcorrencia preco) {
		return new ModelAndView(URI + "view", "preco", preco);
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute("preco") PrecoConcorrencia preco) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView(URI + "form", model);
	}
}
