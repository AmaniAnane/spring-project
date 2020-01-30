package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.dao.ProduitRepository;
import com.example.demo.dao.boutiqueRepository;
import com.example.demo.entities.Produit;
import com.example.demo.entities.*;


@Controller
public class webController {
	 @Autowired 
	 private ProduitRepository produitRepository;
	
	 private boutiqueRepository boutiqueRepository;
	
	 private Produit Produit ;
	  private boutique boutique;
	  
	 @RequestMapping("/Produit/add")
	 public String AddProduit(Model model) {
			model.addAttribute("Produit",new Produit());
			return "AddProduit";
		}
	 @RequestMapping("/boutique/add")
	 public String Addboutique(Model model) {
			model.addAttribute("boutique",new boutique());
			return "Addboutique";
		}
	
	 
	 @RequestMapping(value="/boutique/save",method=RequestMethod.POST)
		public String saveboutique(@Valid @ModelAttribute boutique b , BindingResult bindingResult) {
			
			if (bindingResult.hasErrors()) {
				return "Addboutique" ; 
			}
			boutiqueRepository.save(b);
			return "redirect:/boutique/list";	
		}
	 
		@RequestMapping(value="/boutique/list")
		public String listboutique(Model model) {
			model.addAttribute("boutique",boutiqueRepository.findAll());
			return "Livrerboutique";
	}
	 
	 
	 
	 @RequestMapping(value="/Produit/save",method=RequestMethod.POST)
		public String saveProduit(@Valid @ModelAttribute Produit P , BindingResult bindingResult) {
			
			if (bindingResult.hasErrors()) {
				return "AddProduit" ; 
			}
			produitRepository.save(P);
			return "redirect:/Produit/list";	
		}
		@RequestMapping(value="/Produit/delete",method=RequestMethod.GET)
		public String deleteProduit(Produit P, Long num) {
			produitRepository.deleteById(num);
			
			return "redirect:/Produit/list";
		}
		@RequestMapping(value="/Produit/list")
		public String listProduit(Model model) {
			model.addAttribute("Produit",produitRepository.findAll());
			return "LivrerProduit";
	}
	
	
	
	
	@RequestMapping("Produit/update")
	public String modProduit(Model model,Long num) {
		Produit P=produitRepository.findById(num).get();
		model.addAttribute("Produit",P);
		return "UpdateProduit";
	}
	@RequestMapping(value="/Produit/modifier",method=RequestMethod.POST)
	public String updateProduit(@Valid @ModelAttribute Produit P , BindingResult bindingResult ) {
		if (bindingResult.hasErrors()){
			return "modProduit";
		}
		produitRepository.save(P);
		return "redirect:/Produit/list"; 
	}
	
}
