package com.spring.proyecto2.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.proyecto2.model.Persona;
import com.spring.proyecto2.services.AgendaService;

/**
 * 
 * @author Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 * @version 1.0
 * 
 * Controlador de la agenda usando ModelAndView (Controller)
 *
 */
@Controller
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
	/**
	 * Método para llevar a cabo la comunicación y devolver el listado de contactos de la agenda
	 * @return model Devuelve el modelo de JSP listadoCont
	 */
	@RequestMapping("/")
	public ModelAndView listContactos() {
		List<Persona> listPers = agendaService.list();
		ModelAndView model = new ModelAndView("listadoCont");
		for(Persona i:listPers) {
			System.out.println(i.getNombre());
		}
		model.addObject("listaContactos", listPers);
		return model;
	}
	
	@GetMapping("/delete")
	public ModelAndView borrarContacto(HttpServletRequest request) {
		int idContacto = Integer.parseInt(request.getParameter("id"));
		System.out.println("La id seleccionada es "+idContacto);
		agendaService.delete(idContacto);
		System.out.println("------ se supone que borro");
		return new ModelAndView("redirect:/");
	}
	
	
	

}
